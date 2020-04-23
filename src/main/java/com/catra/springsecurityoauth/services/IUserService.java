package com.catra.springsecurityoauth.services;

import com.catra.springsecurityoauth.entities.User;

public interface IUserService {

   User findByUsername(String username);

}
