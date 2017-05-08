package com.trmsmy.restwithjpa.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BatchConfiguration.class,
		BatchTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BatchTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void testLaunchJob() throws Exception {

		// test a complete job
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

	}

	@Test
	public void testLaunchStep() {

		// test a individual step
		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}
}
