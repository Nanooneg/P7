package com.nanoo.library.clientweb.beans.library;

import com.nanoo.library.clientweb.beans.user.AddressBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:27
 */
@Getter @Setter
@NoArgsConstructor
public class LibraryWithoutBookBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private AddressBean address;
    private String phoneNumber;
    
}
