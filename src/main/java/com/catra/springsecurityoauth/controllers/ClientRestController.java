package com.catra.springsecurityoauth.controllers;

import com.catra.springsecurityoauth.entities.Client;
import com.catra.springsecurityoauth.services.ClientServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

   private final ClientServiceImpl clientService;

   public ClientRestController(ClientServiceImpl clientService) {
      this.clientService = clientService;
   }

   @GetMapping("clients")
   public List<Client> index() {
      return clientService.findAll();
   }

   @GetMapping("clients/{id}")
   public Client getClientService(@PathVariable Long id) {
      return clientService.findById(id);
   }

}
