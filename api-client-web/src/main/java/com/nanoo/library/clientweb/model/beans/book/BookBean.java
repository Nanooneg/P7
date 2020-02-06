package com.nanoo.library.clientweb.model.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:23
 */
@Getter @Setter
@NoArgsConstructor
public class BookBean {
    
    private Integer id;
    private String title;
    private AuthorWithoutBooksBean author;
    private Set<CopyBookBean> copies;
    private String summary;
    private CoverBean cover;
    private String category;
    
}
