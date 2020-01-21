package com.nanoo.library.clientweb.beans.book;

import com.nanoo.library.clientweb.beans.enums.Condition;
import com.nanoo.library.clientweb.beans.library.LibraryLoanBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 21/01/2020 - 13:48
 */
@Getter @Setter
@NoArgsConstructor
public class BookLoanBean {
    
    private Integer id;
    private String title;
    private LibraryLoanBean library;
    private String condition;
    
}
