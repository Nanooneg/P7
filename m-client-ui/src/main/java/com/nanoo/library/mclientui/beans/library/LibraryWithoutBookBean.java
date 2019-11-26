package com.nanoo.library.mclientui.beans.library;

import com.nanoo.library.mclientui.beans.user.AddressBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:27
 */
@Getter @Setter
@NoArgsConstructor
public class LibraryWithoutBookBean {
    
    private Integer id;
    private String name;
    private AddressBean address;
    private String phoneNumber;
    
}
