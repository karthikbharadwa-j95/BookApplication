package com.cts.digibook.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digibook.service.EmailService;


@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/sendemail")
	public String sendEmail() {
		return emailService.sendEmail("karthik.bjmysore@gmail.com", "approval mail", "Hi!");
	}
}

