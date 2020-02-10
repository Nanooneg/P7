package com.nanoo.library.authentication.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 25/11/2019 - 12:19
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_user")
  private int id;
  
  @Column(name = "username", nullable = false)
  private String username;
  
  @Column(name = "password", nullable = false)
  private String password;
  
  @Column(name = "active")
  private boolean active;
  
  @Column(name = "roles", nullable = false)
  private String roles;
  
  @Column(name = "permissions")
  private String permissions;
  
  
  public List<String> getRolesList() {
    if (this.roles.length() > 0) {
      return Arrays.asList(this.roles.split(","));
    }
    return new ArrayList<>();
  }
  
  public List<String> getPermissionsList() {
    if (this.permissions.length() > 0) {
      return Arrays.asList(this.permissions.split(","));
    }
    return new ArrayList<>();
  }
  
}
