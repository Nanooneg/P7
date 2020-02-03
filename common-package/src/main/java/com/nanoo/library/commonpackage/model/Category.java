package com.nanoo.library.commonpackage.model;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:56
 */
public enum Category {
    
    NOVEL("roman"), HISTORICAL("historique"), COMIC("Bande dessinée");
    
    private String name ;
    
    Category(String name) {
        this.name = name ;
    }
    
    public String getName() {
        return  this.name ;
    }
    
}
