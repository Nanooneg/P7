package com.nanoo.library.book.model.dto;

import com.nanoo.library.book.model.entities.Cover;
import com.nanoo.library.book.model.enums.Category;
import com.nanoo.library.book.model.enums.Condition;
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
    private Cover cover;
    private String deweyCode;
    private Category category;
    private Condition condition;
    
}
