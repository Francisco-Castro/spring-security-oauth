package com.catra.springsecurityoauth.services;

import com.catra.springsecurityoauth.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl {

   private final IClientService clientService;

   public ClientServiceImpl(IClientService clientService) {
      this.clientService = clientService;
   }

   public List<Client> findAll() {
      return clientService.findAll();
   }

   public Client findById(Long id) {
      return clientService.findById(id).orElse(null);
   }

}
