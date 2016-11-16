package com.trmsmy.restwithjpa.biz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.trmsmy.restwithjpa.persistence.config.PersistenceConfig;

@Configuration
@Import(value = {PersistenceConfig.class })

@ComponentScan(basePackages = "com.trmsmy.restwithjpa.biz")
@PropertySource(value = { "classpath:{env}.biz.properties" }, ignoreResourceNotFound = true)
public class BizConfig {

}
