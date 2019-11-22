package com.nanoo.library.mmanagementaccount.model.enums;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:24
 */
public enum Role {
    
    ADMIN("Administrateur"), EMPLOYEE("Employé"), CLIENT("Client");
    
    private String abbreviation ;
    
    Role(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
    
}
