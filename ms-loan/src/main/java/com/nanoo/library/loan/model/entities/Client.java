package com.nanoo.library.loan.model.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 23/01/2020 - 10:57
 */
@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id_client")
  private Integer id;
  
  @Column(name = "last_name", nullable = false)
  private String lastName;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;
  
  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "client_number", nullable = false)
  private Long clientNumber;
  
  @OneToMany(mappedBy = "client")
  private Set<Loan> loans;
  
}
