package com.nanoo.library.clientweb.model.beans.library;

import com.nanoo.library.clientweb.model.beans.user.AddressBean;
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
    
    @Override
    public String toString() {
        return "LibraryWithoutBookBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
