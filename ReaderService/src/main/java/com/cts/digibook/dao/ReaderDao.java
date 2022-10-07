package com.cts.digibook.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cts.digibook.entity.Reader;

@Repository
public interface ReaderDao extends JpaRepository<Reader, String> {

	public Reader findByReaderId(String readerId);

	public Reader findByReaderEmail(String readerEmail);
}
