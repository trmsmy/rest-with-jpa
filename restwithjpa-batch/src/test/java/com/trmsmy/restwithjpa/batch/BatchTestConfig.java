package com.trmsmy.restwithjpa.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;

public class BatchTestConfig {

	@Bean
	public JobLauncherTestUtils djdbcTemplate(Job job, JobLauncher jobLauncher, JobRepository jobRepository) {
		JobLauncherTestUtils util = new JobLauncherTestUtils();
		util.setJob(job);
		util.setJobLauncher(jobLauncher);
		util.setJobRepository(jobRepository);
		return util;
	}

}
