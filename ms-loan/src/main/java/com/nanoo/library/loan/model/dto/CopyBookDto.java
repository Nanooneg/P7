package com.nanoo.library.loan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 07/02/2020 - 10:07
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class CopyBookDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String condition;
    private BookDto book;
    
}
