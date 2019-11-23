package com.nanoo.library.mmanagementbook.model.dto;

import com.nanoo.library.mmanagementbook.model.entities.Address;
import com.nanoo.library.mmanagementbook.model.entities.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:47
 */
@Getter @Setter
@NoArgsConstructor
public class LibraryDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Address address;
    private String phoneNumber;
    private Set<Book> books;
    
}
