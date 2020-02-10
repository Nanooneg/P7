package com.nanoo.library.clientweb.model.beans.book;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<CopyBookBean> copies;
    private String summary;
    private CoverBean cover;
    private String category;
    private int availableCopies;
    
}
