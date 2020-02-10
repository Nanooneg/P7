package com.nanoo.library.book.model.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private AuthorDto author;
    private List<CopyBookDto> copies;
    private String summary;
    private CoverOnlyPathDto cover;
    private String category;
    
    private int availableCopies;
    
}
