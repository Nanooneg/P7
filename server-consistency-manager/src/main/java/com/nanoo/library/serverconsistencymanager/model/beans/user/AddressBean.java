package com.nanoo.library.serverconsistencymanager.model.beans.user;

import com.nanoo.library.commonpackage.model.Cities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/01/2020 - 15:45
 */
@Getter @Setter
@NoArgsConstructor
public class AddressBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private int number;
    private String street;
    private int postalCode;
    private Cities city;
    
}
