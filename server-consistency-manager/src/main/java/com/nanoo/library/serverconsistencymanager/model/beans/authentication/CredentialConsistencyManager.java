package com.nanoo.library.serverconsistencymanager.model.beans.authentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nanoo
 * @create 27/01/2020 - 23:15
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class CredentialConsistencyManager {
    
    private String username = "technical-consistency-manager";
    private String password = "456456";
    
}
