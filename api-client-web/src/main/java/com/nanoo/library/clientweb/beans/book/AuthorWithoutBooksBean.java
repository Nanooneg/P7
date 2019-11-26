package com.nanoo.library.clientweb.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:27
 */
@Getter @Setter
@NoArgsConstructor
public class AuthorWithoutBooksBean {
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Date deathDate;
    
}
