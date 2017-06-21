/*package com.example.demo;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;


@IntegrationComponentScan
public class IntegrationConfig {
	
	@Bean(name = "routerInput")
	private MessageChannel routerInput() {
	    return MessageChannels.direct().get();
	}
	
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	  public PollerMetadata poller() {                                       
	  	return Pollers.fixedDelay(1000).get();
	  }
	
	@Bean
	//@InboundChannelAdapter(value = "fileInputChannel", poller = @poller(FixedDelay = "1000"))
	public MessageSource<File> fileReadingMessageSource() {
	    CompositeFileListFilter<File> filters = new CompositeFileListFilter<>();
	    filters.addFilter(new SimplePatternFileListFilter("*.txt"));
	    //filters.addFilter(new LastModifiedFileFilter());
	    
	    FileReadingMessageSource source = new FileReadingMessageSource();
	    source.setAutoCreateDirectory(true);
	    //source.setDirectory(new File(DIRECTORY));
	    source.setFilter(filters);
	    
	    return source;
	}
	
	@Bean
	public IntegrationFlow orderFlow() {
		return IntegrationFlows
				.from("Order.input")
				.get();
	}

}
*/