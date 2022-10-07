package com.cts.digibook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "reader")
public class Reader {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "reader_id")
	private String readerId;

	@Column(name = "reader_name")
	private String readerName;

	@Column(name = "reader_age")
	private String readerAge;

	@Column(name = "reader_email")
	private String readerEmail;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

}