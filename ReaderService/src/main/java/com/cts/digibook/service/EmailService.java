package com.cts.digibook.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("karthik.bjmysore@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		javaMailSender.send(message);

		return "Mail sent successfully!";
	}
}
