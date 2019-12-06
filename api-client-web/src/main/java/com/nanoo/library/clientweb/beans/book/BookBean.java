package com.nanoo.library.clientweb.beans.book;

import com.nanoo.library.clientweb.beans.library.LibraryWithoutBookBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
    private Set<AuthorWithoutBooksBean> authors;
    private String summary;
    private CoverBean cover;
    private LibraryWithoutBookBean library;
    private String deweyCode;
    private String category;
    private String condition;
    private boolean available;
    
}
