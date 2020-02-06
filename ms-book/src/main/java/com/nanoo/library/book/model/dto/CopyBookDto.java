package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 06/02/2020 - 11:06
 */
@Getter @Setter
@NoArgsConstructor
public class CopyBookDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private boolean available;
    private String condition;
    private BookWithoutCopiesDto book;
    private LibraryDto library;
    
}
