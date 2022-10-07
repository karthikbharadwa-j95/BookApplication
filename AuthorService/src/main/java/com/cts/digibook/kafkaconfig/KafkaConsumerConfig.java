//package com.cts.digibook.author.kafkaconfig;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import com.cts.digibook.author.entity.BookShelf;
//
//@EnableKafka
//@Configuration
//public class KafkaConsumerConfig {
//
//	@Bean
//	public ConsumerFactory<String, BookShelf> userConsumerFactory() {
//		Map<String, Object> config = new HashMap<>();
//
//		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//
//		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
//				new JsonDeserializer<>(BookShelf.class));
//
//	}
//
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, BookShelf> userKafkaListenerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, BookShelf> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(userConsumerFactory());
//		return factory;
//	}
//
//}
