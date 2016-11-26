package com.trmsmy.restwithjpa.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.trmsmy.restwithjpa.persistence.*" })
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource(value = { "classpath:${env:dev}.persistence.properties" }, ignoreResourceNotFound = true)
@Import(DataSourceConfig.class)
public class PersistenceConfig {

	public static final String PU_JPA = "JPA_PU_MSSQL";

	public static final String[] PACKAGES_TO_SCAN = { "com.trmsmy.restwithjpa.persistence.**.entity",
			"com.trmsmy.restwithjpa.persistence.**.converter" };

	@Value("${hibernate.show.sql}")
	public static String showSql;

	@Value("${db.default.schema}")
	public static String defaultSchema;
	
	@Autowired
	DataSource datasource;
	
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

	public Properties properties() {

		Properties properties = new Properties();

		// properties.setProperty("javax.persistence.transactionType", "JTA");

		// CACHE CONFIGS
		properties.setProperty("javax.persistence.sharedCache.mode", "NONE");
		properties.setProperty("hibernate.cache.use_second_level_cache", "false");
		properties.setProperty("hibernate.cache.use_query_cache", "false");
		// properties.setProperty("hibernate.cache.region.factory_class",
		// "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		// properties.setProperty("net.sf.ehcache.configurationResourceName",
		// "ehcache-phx-default.xml");

		properties.setProperty("hibernate.generate_statistics", "false");
		properties.setProperty("hibernate.current_session_context_class", "jta");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		/*
		 * properties.setProperty("hibernate.transaction.manager_lookup_class",
		 * "org.hibernate.transaction.WebSphereExtendedJTATransactionLookup");
		 */
		properties.setProperty("hibernate.transaction.jta.platform",
				"org.hibernate.service.jta.platform.internal.BitronixJtaPlatform");

		// properties.setProperty("hibernate.transaction.jta.platform",
		// "org.hibernate.service.jta.platform.internal.WebSphereExtendedJtaPlatform");
		// properties.setProperty("hibernate.current_session_context_class",
		// "jta");
		properties.setProperty("hibernate.search.autoregister_listeners", "false");
		properties.setProperty("hibernate.jdbc.batch_size", "500");
		properties.setProperty("hibernate.id.new_generator_mappings", "true");
		properties.setProperty("hibernate.archive.autodetection", "class");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.show_sql", "true");

		return properties;
	}

}
