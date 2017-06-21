package com.example.demo;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageHandler;

public class BatchConfig {

	@Autowired
	private JobLauncher jobLauncher;

	@Bean
	public MessageHandler jobLaunchingGw() {
	    return new JobLaunchingGateway(jobLauncher);   
	} 
}
