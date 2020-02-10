package com.nanoo.library.book.model.entities;

import java.io.Serializable;
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
 * @create 22/11/2019 - 23:09
 */
@Entity
@Table(name = "cover")
@Getter
@Setter
@NoArgsConstructor
public class Cover implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_cover")
  private Integer id;
  
  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "path", nullable = false)
  private String path;
  
}
