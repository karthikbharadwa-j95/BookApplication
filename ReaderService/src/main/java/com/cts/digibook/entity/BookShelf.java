package com.cts.digibook.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book_shelf")
public class BookShelf {

	@Column(name = "title")
	private String title;

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id")
	private String bookId;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private Double price;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "book_status")
	private Integer bookStatus;

	@Column(name = "content")
	private String content;

	@Column(name = "author_book_id")
	private String authorBookId;
}