package com.cts.digibook.passwordgenerator;

import java.util.Random;


import org.springframework.stereotype.Component;

@Component
public class GeneratePassword {

	public String passwordGenerator(int lengthOfPassword) {

		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String Lower = "abcdefghijklmnopgrstuvwxyz";

		String num = "0123456789";

		String specialChars = "<>, .?/}]{]+_-) (&%$#@!=";

		String combination = upper + Lower + specialChars + num;

		String password = "";

		Random r = new Random();

		for (int i = 0; i < lengthOfPassword; i++) {
			password += combination.charAt(r.nextInt(combination.length()));
		}

		return password;
	}

//	public static void main(String[] args) {
//		GeneratePassword password = new GeneratePassword();
//
//		System.out.println(password.passwordGeneraotr(10));
//	}
}
