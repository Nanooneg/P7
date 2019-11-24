package com.nanoo.library.emzuulserver.configurations;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

/**
 * @author nanoo
 * @create 24/11/2019 - 16:28
 */
@Configuration
public class SleuthConfig {
    
    public Sampler defaultSampler(){
        
        return Sampler.ALWAYS_SAMPLE;
        
    }
    
}
