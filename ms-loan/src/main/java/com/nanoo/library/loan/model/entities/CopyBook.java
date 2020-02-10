package com.nanoo.library.loan.model.entities;

import com.nanoo.library.commonpackage.model.Condition;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
 * @create 07/02/2020 - 09:52
 */
@Entity
@Table(name = "copy_book")
@Getter
@Setter
@NoArgsConstructor
public class CopyBook implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id_copy_book")
  private Integer id;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "condition", length = 20, nullable = false)
  private Condition condition;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_book", nullable = false)
  private Book book;
  
  @OneToMany(mappedBy = "copyBook")
  private Set<Loan> loans;
  
}
