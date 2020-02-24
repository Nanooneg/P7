package com.nanoo.library.book.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:43
 */
@Getter @Setter
@NoArgsConstructor
public class AuthorDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String lastName;
    private String firstName;
    
}
