package com.nanoo.library.clientweb.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 01/12/2019 - 20:22
 */
@Getter @Setter
@NoArgsConstructor
public class BookSearchAttribut {
    
    private String searchValue;
    private String searchCriteria;
    private boolean available;
    
    @Override
    public String toString() {
        return "BookSearchAttributBean{" +
                "title='" + searchValue + '\'' +
                ", author='" + searchCriteria + '\'' +
                ", available=" + available +
                '}';
    }
}
