package com.nanoo.library.book.model.entities;

import com.nanoo.library.commonpackage.model.Cities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:08
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_address")
  private Integer id;
  
  @Column(name = "number", nullable = false)
  private int number;
  
  @Column(name = "street", length = 50, nullable = false)
  private String street;
  
  @Column(name = "postal_code", length = 5, nullable = false)
  private int postalCode;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "city", nullable = false)
  private Cities city;
  
}
