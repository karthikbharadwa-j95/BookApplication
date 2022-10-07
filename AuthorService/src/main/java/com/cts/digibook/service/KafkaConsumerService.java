//package com.cts.digibook.author.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.cts.digibook.author.entity.BookShelf;
//
//
//@Service
//public class KafkaConsumerService {
//
//	@Autowired
//	private EmailService emailService;
//
//	@KafkaListener(topics = "kafka_topic", groupId = "group_id", containerFactory = "userKafkaListenerFactory")
//	public void consumeJson(BookShelf bookShelf) {
//		System.out.println("Consumed JSON message:" + bookShelf);
//		emailService.sendEmail("karthik.bjmysore@gmail.com", "Attention!! A Book was updated by author!",
//				"Details as follows: " + bookShelf);
//	}
//
//}
//
