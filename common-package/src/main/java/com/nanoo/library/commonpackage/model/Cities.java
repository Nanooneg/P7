package com.nanoo.library.commonpackage.model;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:36
 */
public enum Cities {
    
    BX("Bordeaux"), MGC("Mérignac"), PC("Pessac");
    
    private String name ;
    
    Cities(String name) {
        this.name = name ;
    }
    
    public String getName() {
        return  this.name ;
    }
    
}
