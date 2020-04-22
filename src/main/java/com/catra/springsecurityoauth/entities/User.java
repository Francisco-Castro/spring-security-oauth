package com.catra.springsecurityoauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true, length = 25)
   private String username;

   @Column(length = 60)
   private String password;

   private Boolean enabled;

   /**
    * Cascade.ALL
    * when a user is deleted also the roles are deleted or
    * if a user is created also the roles are created.
    */
   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   /**
    * To change default values we can use JoinTable so we can
    * define column custom names (ForeignKeys) and so on over the automatic
    * table created.
    * uniqueConstraints are use to don't have duplicates set of pairs.
    * */
   @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"),
      uniqueConstraints = {
         @UniqueConstraint(columnNames = {
            "user_id", "role_id"
         })
      }
   )
   @JsonIgnore
   private List<Role> roles;

   private static final long serialVersionUID = 1L;
}
