package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    private Set<BookWithoutAuthorsAndLibraryDto> books;
    private Date birthDate;
    private Date deathDate;
    
}
