package com.nanoo.library.clientweb.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 01/12/2019 - 20:22
 */
@Getter
@Setter
@NoArgsConstructor
public class BookSearchAttributBean {
    
    private String title;
    private AuthorWithoutBooksBean author;
    private boolean available;
    
}
