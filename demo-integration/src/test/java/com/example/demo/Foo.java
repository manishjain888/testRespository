package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = Foo.Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Foo {

	@Autowired
	@Qualifier("flow.input")
	private MessageChannel in;
	
	
	@Test
	public void test(){
		new MessagingTemplate().convertAndSend(in, "foo");
		
	}
	
	@Configuration
	@EnableIntegration
	public static class Config{
		
		@Bean
		public IntegrationFlow flow(){
			
			return f ->f
					//.transform("@myTransformer.transform(payload)") //1
				.<String, String>transform(p -> p.toUpperCase())	//2
					.handle(logger());
			
		}
		
		@Bean
		public MessageHandler logger(){
			 return new LoggingHandler("WARN");
		}
		
		/*@Bean
		public Object myTransformer(){
			return new Object(){
				public String transform(String in){
					return (in + in).toUpperCase();
				}
			};
		}*/
		
		
		
		
		
		
	}
	
}
