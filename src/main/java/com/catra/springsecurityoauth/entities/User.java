package com.catra.springsecurityoauth.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true, length = 25)
   private String username;

   @Column(length = 20)
   private String password;

   private Boolean enabled;

   private static final long serialVersionUID = 1L;
}
