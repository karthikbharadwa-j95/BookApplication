package com.cts.digibook.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class SearchBooks {

	private String category;
	private String author;
	private String publisher;
	private Double price;
}
