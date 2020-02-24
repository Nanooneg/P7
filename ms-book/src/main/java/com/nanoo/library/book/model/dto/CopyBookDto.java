package com.nanoo.library.book.model.dto;

import java.io.Serializable;
import java.util.Comparator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 06/02/2020 - 11:06
 */
@Getter @Setter
@NoArgsConstructor
public class CopyBookDto implements Serializable, Comparator<CopyBookDto> {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private boolean available;
    private String condition;
    private BookWithoutCopiesDto book;
    private LibraryDto library;
    
    
    @Override
    public int compare(CopyBookDto o1, CopyBookDto o2) {
        return o1.library.getId() - o2.library.getId();
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (id == null ? 0 : id.hashCode());
        return hashno;
    }
    
}
