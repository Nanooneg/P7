package com.nanoo.library.commonpackage.model;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:01
 */
public enum Condition {
    
    NEW("neuf"),
    GOOD("bon état"),
    WORN("usé"),
    DAMAGING("abimé");
    
    private String entitled ;
    
    Condition(String entitled) {
        this.entitled = entitled ;
    }
    
    public String getEntitled() {
        return  this.entitled ;
    }
    
    
}
