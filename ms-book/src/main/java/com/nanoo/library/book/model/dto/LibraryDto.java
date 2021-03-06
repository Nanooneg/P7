package com.nanoo.library.book.model.dto;

import com.nanoo.library.book.model.entities.Address;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:47
 */
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class LibraryDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Address address;
    private String phoneNumber;
    
}
