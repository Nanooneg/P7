package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 06/02/2020 - 15:50
 */
@Getter @Setter
@NoArgsConstructor
public class BookWithoutCopiesDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String title;
    private AuthorDto author;
    private String summary;
    private CoverOnlyPathDto cover;
    private String category;
    
}
