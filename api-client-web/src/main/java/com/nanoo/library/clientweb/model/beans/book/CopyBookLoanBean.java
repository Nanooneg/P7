package com.nanoo.library.clientweb.model.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nanoo
 * @create 07/02/2020 - 11:25
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class CopyBookLoanBean {
    
    private Integer id;
    private String condition;
    private BookLoanBean book;

}
