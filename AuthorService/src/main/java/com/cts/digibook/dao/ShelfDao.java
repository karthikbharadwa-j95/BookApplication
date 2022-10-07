package com.cts.digibook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.digibook.entity.BookShelf;

@Repository
public interface ShelfDao extends JpaRepository<BookShelf, String> {

	public BookShelf findByBookIdAndAuthorBookId(String bookId, String authorId);

	public BookShelf findByBookId(String bookId);

}