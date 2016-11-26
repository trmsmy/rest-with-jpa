package com.trmsmy.restwithjpa.persistence.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class PersistenceTestConfig {

	@Value("${db.user}")
	public String username;

	// @Value("${db.password}")
	public String password = "my-secret-pw";

	public static String showSql;

/*
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJtaDataSource(datasource);
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(properties());
		em.setPersistenceUnitName(PU_JPA);
		em.setPackagesToScan(PACKAGES_TO_SCAN);

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

    @Profile("!test")
	public DataSource datasource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		return dsLookup.getDataSource(JNDI_DATASOURCE);
	}
*/
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// @Value("${db.url}")
	private String datasourceUrl = "jdbc:mysql://172.17.0.2:3306/restwithjpa?allowMultiQueries=true";

	@Bean
	public DataSource datasource() {

		System.out.println("datasourceUrl       " + username);

		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl(datasourceUrl);
		dm.setUsername(username);
		dm.setPassword(password);
		return dm;
	}

}
