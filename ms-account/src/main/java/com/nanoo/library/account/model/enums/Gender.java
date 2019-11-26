package com.nanoo.library.account.model.enums;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:24
 */
public enum Gender {
    
    MALE("H","Homme"), FEMALE("F", "Femme");
    
    private String abbreviation ;
    private String entitled;
    
    Gender(String abbreviation, String entitled) {
        this.abbreviation = abbreviation ;
        this.entitled = entitled;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
    public String getEntitled() { return this.entitled ; }
}
