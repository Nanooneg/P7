package com.nanoo.library.mmanagementaccount.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:43
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Client extends Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "client_number", unique = true, nullable = false)
    private Long clientNumber;
    
}
