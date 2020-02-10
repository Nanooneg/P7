package com.nanoo.library.book.model.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:06
 */
@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
public class Author implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_author")
  private Integer id;
  
  @Column(name = "last_name", nullable = false)
  private String lastName;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;
  
  @OneToMany(mappedBy = "author")
  private Set<Book> books;
  
}
