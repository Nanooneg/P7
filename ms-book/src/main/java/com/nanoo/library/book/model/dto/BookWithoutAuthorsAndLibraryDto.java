package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 23/11/2019 - 14:42
 */
@Getter @Setter
@NoArgsConstructor
public class BookWithoutAuthorsAndLibraryDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String title;
    private String summary;
    private CoverOnlyPathDto cover;
    private String deweyCode;
    private String category;
    private String condition;
    private boolean available;
    
}
