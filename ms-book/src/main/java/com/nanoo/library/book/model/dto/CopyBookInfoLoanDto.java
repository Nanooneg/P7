package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 07/02/2020 - 10:10
 */
@Getter @Setter
@NoArgsConstructor
public class CopyBookInfoLoanDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String condition;
    private BookWithoutCopiesDto book;
    
}
