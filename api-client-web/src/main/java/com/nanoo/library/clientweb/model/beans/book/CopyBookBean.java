package com.nanoo.library.clientweb.model.beans.book;

import com.nanoo.library.clientweb.model.beans.library.LibraryWithoutBookBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 06/02/2020 - 15:15
 */
@Getter @Setter
@NoArgsConstructor
public class CopyBookBean {
    
    private Integer id;
    private boolean available;
    private String condition;
    private BookBean book;
    private LibraryWithoutBookBean library;
    
}
