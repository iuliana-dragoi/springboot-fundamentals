package com.crode.springboot_fundamentals.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String version;
    private boolean displayBeans;
}
