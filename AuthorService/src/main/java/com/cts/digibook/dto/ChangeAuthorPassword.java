package com.cts.digibook.dto;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ChangeAuthorPassword {

	private String authorId;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	private String username;
}
