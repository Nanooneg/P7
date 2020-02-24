package com.nanoo.library.account.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 21/02/2020 - 16:32
 */
@Getter @Setter
@NoArgsConstructor
public class AddressDto implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private Integer id;
  private int number;
  private String street;
  private int postalCode;
  private String city;
  
}
