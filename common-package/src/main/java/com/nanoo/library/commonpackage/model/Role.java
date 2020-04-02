package com.nanoo.library.commonpackage.model;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:24
 */
public enum Role {
    
    ADMIN("Administrateur","ADMIN"),
    EMPLOYEE("Employé","EMPLOYEE"),
    CLIENT("Client","CLIENT"),
    TECHNICAL("Technical","TECHNICAL");
    
    private String abbreviation ;
    private String abb;
    
    Role(String abbreviation, String abb) {

        this.abbreviation = abbreviation ;
        this.abb = abb;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }

    public String getAbb(){ return this.abb; }
    
}
