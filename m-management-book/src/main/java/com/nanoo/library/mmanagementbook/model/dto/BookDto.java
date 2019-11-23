package com.nanoo.library.mmanagementbook.model.dto;

import com.nanoo.library.mmanagementbook.model.entities.Author;
import com.nanoo.library.mmanagementbook.model.entities.Cover;
import com.nanoo.library.mmanagementbook.model.entities.Library;
import com.nanoo.library.mmanagementbook.model.enums.Category;
import com.nanoo.library.mmanagementbook.model.enums.Condition;
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
    private Set<Author> authors;
    private Cover cover;
    private Library library;
    private String deweyCode;
    private Category category;
    private Condition condition;
    
}
