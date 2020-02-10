package com.nanoo.library.account.model.entities;

import com.nanoo.library.commonpackage.model.Gender;
import com.nanoo.library.commonpackage.model.Role;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:16
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
class Account implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_account")
  private Integer id;
  
  @Column(name = "last_name", nullable = false)
  private String lastName;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;
  
  @Column(name = "birth_date", nullable = false)
  private Date birthDate;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "gender", length = 10, nullable = false)
  private Gender gender;
  
  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;
  
  @Column(name = "email", length = 50, unique = true, nullable = false)
  private String email;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_address")
  private Address address;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;
  
  @Column(name = "date_of_creation", nullable = false)
  private Date dateOfCreation;
  
  @Column(name = "date_of_update", nullable = false)
  private Date dateOfUpdate;
  
}
