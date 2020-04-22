package com.catra.springsecurityoauth.dao;

import com.catra.springsecurityoauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

   User findByUsername(String username);

}
