package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@IntegrationComponentScan
public class IntergrationFlowStingUpperCase {

	@Autowired
	public MessageChannel foo;
	
	@Bean
	public IntegrationFlow orderFlow() {
		return IntegrationFlows
				.from(foo)
				.transform("payload+payload")
				
				.handle(String.class, (p,h)-> p.toUpperCase())
				.get();
	}
}
