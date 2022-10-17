package com.cts.digibook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.digibook.dto.SearchBooks;
import com.cts.digibook.entity.BookShelf;

@Repository
public interface ShelfDao extends JpaRepository<BookShelf, String> {

	public BookShelf findByBookIdAndAuthorBookId(String bookId, String authorId);

	public BookShelf findByBookId(String bookId);

	@Query(nativeQuery = false, value = "Select b from BookShelf b where b.category = ?1 and b.authorBookId = ?2 and b.price = ?3 and b.publisher = ?4 and b.bookStatus=0")
	public List<BookShelf> findBookShelf(String category, String author, Double price, String publisher);

	@Query(nativeQuery = false, value = "Select b from BookShelf b where b.category = ?1 and b.bookStatus=0")
	public List<BookShelf> findByCategory(String category);

	@Query(nativeQuery = false, value = "Select b from BookShelf b where b.authorBookId = ?1 and b.bookStatus=0")
	public List<BookShelf> findByAuthorBookId(String authorBookId);

	@Query(nativeQuery = false, value = "Select b from BookShelf b where b.price = ?1 and b.bookStatus=0")
	public List<BookShelf> findbyPrice(Double price);

	@Query(nativeQuery = false, value = "Select b from BookShelf b where b.publisher = ?1 and b.bookStatus=0")
	public List<BookShelf> findbyPublisher(String publisher);

}
