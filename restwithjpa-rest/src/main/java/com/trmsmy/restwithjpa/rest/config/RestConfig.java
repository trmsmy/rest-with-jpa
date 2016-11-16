package com.trmsmy.restwithjpa.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.trmsmy.restwithjpa.biz.config.BizConfig;


@Configuration
@Import(value = {BizConfig.class })
@ImportResource({

})
@ComponentScan(basePackages = "com.trmsmy.restwithjpa")
public class RestConfig {

	
    
}
