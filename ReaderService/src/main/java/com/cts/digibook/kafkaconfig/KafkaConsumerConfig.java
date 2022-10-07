package com.cts.digibook.kafkaconfig;

import java.util.HashMap;


import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.cts.digibook.entity.BookShelf;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, BookShelf> userConsumerFactory() {
		System.out.println("CONSUMER");
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(BookShelf.class));

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, BookShelf> userKafkaListenerFactory() {
		System.out.println("ENTERED!");
		ConcurrentKafkaListenerContainerFactory<String, BookShelf> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

}

//@KafkaListener(topics = "kafka-topic", groupId="group_id", containerFactory = "userKafkaListenerFactory")
//public void consumeJson(BookShelf book) {
//    System.out.println("Consumed JSON Message: " + book);
//
//    // notify users
//    // start shipment
//    // cancel delivery
//}