package com.nanoo.library.mmanagementloan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:43
 */
@Getter @Setter
@NoArgsConstructor
public class LibraryDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    
}
