package com.catra.springsecurityoauth.auth;

import com.catra.springsecurityoauth.entities.User;
import com.catra.springsecurityoauth.services.IUserService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer {

   private final IUserService userService;

   public InfoAdditionalToken(IUserService userService) {
      this.userService = userService;
   }

   @Override
   public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

      User user = userService.findByUsername(oAuth2Authentication.getName());

      Map<String, Object> info = new HashMap<>();
      info.put("additional_info", "More info...".concat(oAuth2Authentication.getName()));
      info.put("id_name", user.getId() + ": " + user.getUsername());

      ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

      return oAuth2AccessToken;
   }

}
