package com.cts.digibook.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
public class Author {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "author_id")
	private String authorId;

	@Column(name = "author_name")
	private String auhthorName;

	@Column(name = "author_email")
	private String authorEmail;

	@Column(name = "author_gender")
	private String authorGender;

	@Column(name = "is_account_active")
	private Integer isAccountActive;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
//	@Column(name="author_book_id")
//	private String authorBookId;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "author_bokk_id")
//	private List<BookShelf> bookShelfs;
}