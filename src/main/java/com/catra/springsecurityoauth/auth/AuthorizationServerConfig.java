package com.catra.springsecurityoauth.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

   private final BCryptPasswordEncoder passwordEncoder;
   private final AuthenticationManager authenticationManager;


   public AuthorizationServerConfig(BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
      this.passwordEncoder = passwordEncoder;
      this.authenticationManager = authenticationManager;
   }

   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      security.tokenKeyAccess("permitAll()") // Login endpoint /oauth/token/. Generate token if authenticated
         .checkTokenAccess("isAuthenticated()"); // Endpoint verify token and signature /oauth/check_token

      super.configure(security);
   }

   /**
    * client CONFIGURATION. inMemory - other opts. jdbc, jpa, etc.
    */
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory()
         .withClient("angularApp")
         .secret(passwordEncoder.encode("12345"))
         .scopes("read", "write")
         .authorizedGrantTypes("password", "refresh_token")
         .accessTokenValiditySeconds(3600)
         .refreshTokenValiditySeconds(3600);
   }

   /**
    * Token CONFIGURATION
    */
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

//      TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//      tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken));
      endpoints.authenticationManager(authenticationManager)
         .accessTokenConverter(accessTokenConverter());
   }

   /**
    * Authentication Oauth - Implementation token JWT. Decoding and Coding data (username, roles, extras -claims)
    */
   @Bean
   public JwtAccessTokenConverter accessTokenConverter() {
      JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
      jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
      jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
      return jwtAccessTokenConverter;
   }
}
