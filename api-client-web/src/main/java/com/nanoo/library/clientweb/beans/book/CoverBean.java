package com.nanoo.library.clientweb.beans.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:27
 */
@Getter @Setter
@NoArgsConstructor
public class CoverBean {
    
    private Integer id;
    private String title;
    private String path;
    
}
