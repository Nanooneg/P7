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
 * @create 21/11/2019 - 15:43
 */
@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends Account implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Column(name = "client_number", unique = true, nullable = false)
  private Long clientNumber;
  
}
