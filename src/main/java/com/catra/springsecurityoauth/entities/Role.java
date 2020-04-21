package com.catra.springsecurityoauth.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true, length = 25)
   private String name;

   /**
    * This List of user is only for educational purposes, it's not necessary.
    * In this case we only need the List of roles from the users, not in the
    * order way around.
    * */
   @ManyToMany(mappedBy = "roles")
   private List<User> users;

   private static final long serialVersionUID = 1L;

}
