package com.nanoo.library.mmanagementaccount.model.enums;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:36
 */
public enum City {
    
    BX("Bordeaux"), MGC("Mérignac"), PC("Pessac");
    
    private String name ;
    
    City(String name) {
        this.name = name ;
    }
    
    public String getName() {
        return  this.name ;
    }
    
}
