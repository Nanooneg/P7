package com.nanoo.library.mclientui.beans.book;

import com.nanoo.library.mclientui.beans.library.LibraryWithoutBookBean;
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
    private Set<AuthorWithoutBooksBean> authors;
    private CoverBean cover;
    private LibraryWithoutBookBean library;
    private String deweyCode;
    private String category;
    private String condition;
    
}
