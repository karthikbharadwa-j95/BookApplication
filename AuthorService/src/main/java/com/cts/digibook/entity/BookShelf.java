package com.cts.digibook.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book_shelf")
public class BookShelf {

//	public BookShelf(String bookId2, Integer bookStatus2, String category2, String content2, Double price2,
//			String title2, String publisher2) {
//	}

	@Column(name = "title")
	private String title;

	public BookShelf(String bookId, Integer bookStatus, String category, String content, Double price, String publisher,
			String authorBookId) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.bookStatus = bookStatus;
		this.content = content;
		this.authorBookId = authorBookId;
	}

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id")
	private String bookId;

	@Column(name = "category")
	private String category;

//	@Lob
//	@Column(name = "image")
//	private byte[] image;

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
