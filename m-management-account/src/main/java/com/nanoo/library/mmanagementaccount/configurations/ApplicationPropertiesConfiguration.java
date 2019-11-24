package com.nanoo.library.mmanagementaccount.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author nanoo
 * @create 24/11/2019 - 10:52
 */
@Component
@ConfigurationProperties("config-account")
//@RefreshScope //after a refresh request, new config in could server will be picked up without restart the MS
public class ApplicationPropertiesConfiguration {


}
