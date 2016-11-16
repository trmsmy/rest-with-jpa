package com.trmsmy.restwithjpa.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(
	basePackages = {
		"com.trmsmy.restwithjpa.persistence.*"
	}
)
@EnableTransactionManagement(proxyTargetClass = true)
public class PersistenceConfig {

}
