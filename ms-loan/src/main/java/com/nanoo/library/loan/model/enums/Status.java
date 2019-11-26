package com.nanoo.library.loan.model.enums;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:01
 */
public enum Status {
    
    ONGOING("en cours"),
    OUTDATED("dépassé"),
    FINISH("fini");
    
    private String entitled ;
    
    Status(String entitled) {
        this.entitled = entitled ;
    }
    
    public String getEntitled() {
        return  this.entitled ;
    }
    
    
}
