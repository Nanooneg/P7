package com.nanoo.library.mmanagementaccount.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author nanoo
 * @create 24/11/2019 - 10:52
 */
@Component
@ConfigurationProperties("config-account")
@RefreshScope
public class ApplicationPropertiesConfiguration {


}
