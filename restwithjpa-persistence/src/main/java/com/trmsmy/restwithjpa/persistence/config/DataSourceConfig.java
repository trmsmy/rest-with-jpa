package com.trmsmy.restwithjpa.persistence.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DataSourceConfig {
	
	private static final String JNDI_DATASOURCE = "jdbc/restDemoDB";
	
	@Bean
	@Profile("!test")
	public DataSource datasource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		return dsLookup.getDataSource(JNDI_DATASOURCE);
	}
	
}
