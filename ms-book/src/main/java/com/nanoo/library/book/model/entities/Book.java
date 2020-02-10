package com.nanoo.library.book.model.entities;

import com.nanoo.library.commonpackage.model.Category;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:04
 */
@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_book")
  private Integer id;
  
  @Column(name = "title", length = 50, nullable = false)
  private String title;
  
  @ManyToOne
  @JoinColumn(name = "id_author", nullable = false)
  private Author author;
  
  @OneToMany(mappedBy = "book")
  private Set<CopyBook> copies;
  
  @Column(name = "summary", length = 400)
  private String summary;
  
  @ManyToOne
  @JoinColumn(name = "id_cover")
  private Cover cover;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "category", length = 20, nullable = false)
  private Category category;
  
  @Column(name = "registration", nullable = false)
  private Date registration;
}
