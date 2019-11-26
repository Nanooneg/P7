package com.nanoo.library.book.model.dto;

import com.nanoo.library.book.model.entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 23/11/2019 - 14:57
 */
@Getter @Setter
@NoArgsConstructor
public class LibraryWithoutBooksDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private Address address;
    private String phoneNumber;
    
}
