package com.nanoo.library.book.model.dto;

import com.nanoo.library.book.model.entities.Author;
import com.nanoo.library.book.model.entities.CopyBook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 21/01/2020 - 13:35
 */
@Getter @Setter
@NoArgsConstructor
public class BookInfoLoanDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String title;
    private CoverOnlyPathDto cover;
    
}
