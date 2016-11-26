package com.trmsmy.restwithjpa.persistence.dao;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trmsmy.restwithjpa.persistence.config.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes= {PersistenceConfig.class, PersistenceTestConfig.class})
public class BaseDaoIntegTest {

	private JdbcTemplate template;

	@BeforeClass
	public static void setup() {
		System.setProperty("env", "test");
	}
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	protected JdbcTemplate getJdbcTemplate() {
		return this.template;
	}

	@Test //DONT DELETE, JUNIT NEEDS ME! 
	public void dummyTest() {
		Assert.assertTrue(true);
	}

}
