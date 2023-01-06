package com.kirangs.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	//default partitions and replicas provided by kafka
	@Bean
	public NewTopic myFirstTopic() {

		return TopicBuilder.name("firstTopic")
				.build();
	}
	
//	@Bean
//	public NewTopic myFirstTopic() {
//		return TopicBuilder.name("firstTopic")
//				.partitions(10)
//				.replicas(1)
//				.build();
//	}

}
