package com.nanoo.library.loan.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 23/01/2020 - 10:58
 */
@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id_book")
  private Integer id;
  
  @Column(name = "title", length = 50, nullable = false)
  private String title;
  
  @Column(name = "cover", nullable = false)
  private String cover;
  
  
}
