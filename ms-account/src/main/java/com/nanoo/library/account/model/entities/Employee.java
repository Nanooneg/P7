package com.nanoo.library.account.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:39
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Account implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Column(name = "employee_number", unique = true, nullable = false)
  private Long employeeNumber;
  @Column(name = "social_number", unique = true, nullable = false)
  private Long socialNumber;
  
}
