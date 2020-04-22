package com.catra.springsecurityoauth.services;

import com.catra.springsecurityoauth.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientService extends JpaRepository<Client, Long> {

}
