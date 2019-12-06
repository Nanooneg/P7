package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 01/12/2019 - 23:47
 */
@Getter @Setter
@NoArgsConstructor
public class CoverOnlyPathDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String path;
}
