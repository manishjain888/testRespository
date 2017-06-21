package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
@IntegrationComponentScan
@SpringBootApplication
public class DemoIntegrationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoIntegrationApplication.class, args);
		System.out.println(ctx.getBean(FooService.class).foo("foo"));
	}
	
	@MessagingGateway(defaultRequestChannel="flow.input")
	public static interface FooService {
		String foo(String request);
	}
	
	@Bean
	public MessageChannel foo(){
		return new DirectChannel();
	}
	
	
}
