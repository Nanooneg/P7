package com.nanoo.library.commonpackage.model;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:24
 */
public enum Role {
    
    ADMIN("Administrateur"),
    EMPLOYEE("Employé"),
    CLIENT("Client"),
    TECHNICAL("Technical");
    
    private String abbreviation ;
    
    Role(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
    
}
