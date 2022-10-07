package com.cts.digibook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cts.digibook.entity.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, String> {

	public Author findByAuthorId(String authorId);
}
