package com.catra.springsecurityoauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//public class SpringSecurityOauthApplication implements CommandLineRunner {
public class SpringSecurityOauthApplication {

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   public static void main(String[] args) {
      SpringApplication.run(SpringSecurityOauthApplication.class, args);
   }

//   @Override
//   public void run(String... args) throws Exception {
//
//      for (int i = 0; i < 4; i++) {
//         String passwordBCrypt = passwordEncoder.encode("12345");
//         System.out.println(passwordBCrypt);
//      }
//   }

}
