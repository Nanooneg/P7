package com.nanoo.library.clientweb.model.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nanoo
 * @create 21/01/2020 - 13:48
 */
@Getter @Setter
@NoArgsConstructor
@ToString
class BookLoanBean {
    
    private Integer id;
    private String title;
    private String cover;
    
}
