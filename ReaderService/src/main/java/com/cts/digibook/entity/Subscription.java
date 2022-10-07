package com.cts.digibook.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "sub_id")
	private String subscriptionId;

	@Column(name = "sub_reader_id")
	private String subReaderId;

	@Column(name = "sub_Reader_Email")
	private String subReaderEmail;

	@Column(name = "sub_book_id")
	private String subBookId;

	@Column(name = "sub_book_name")
	private String subBookName;

}