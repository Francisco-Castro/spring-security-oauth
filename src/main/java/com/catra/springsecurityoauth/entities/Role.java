package com.catra.springsecurityoauth.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true, length = 25)
   private String name;

   private static final long serialVersionUID = 1L;

}
