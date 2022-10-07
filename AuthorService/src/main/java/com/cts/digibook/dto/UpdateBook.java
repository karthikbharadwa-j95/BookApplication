package com.cts.digibook.dto;

import javax.persistence.Column;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBook {

	private String bookTitle;

	private String bookId;

	private String category;

	private Double price;

	private String publisher;

	private Integer bookStatus;

	private String content;

	private String authorBookId;
}
