package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:37
 */
@Getter @Setter
@NoArgsConstructor
public class BookDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private Set<AuthorWithoutBooksDto> authors;
    private String summary;
    private CoverOnlyPathDto cover;
    private LibraryWithoutBooksDto library;
    private String deweyCode;
    private String category;
    private String condition;
    private boolean available;
    
}
