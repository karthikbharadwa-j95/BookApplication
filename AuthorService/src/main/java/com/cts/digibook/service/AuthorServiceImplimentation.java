package com.cts.digibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cts.digibook.dao.AuthorDao;
import com.cts.digibook.dao.ShelfDao;
import com.cts.digibook.dao.UserDao;
import com.cts.digibook.dto.ChangeAuthorPassword;
import com.cts.digibook.dto.UpdateBook;
import com.cts.digibook.entity.Author;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.entity.User;
import com.cts.digibook.exception.AuthorException;
import com.cts.digibook.passwordgenerator.GeneratePassword;

@Service
public class AuthorServiceImplimentation implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ShelfDao shelfDao;

	@Autowired
	private KafkaTemplate<String, BookShelf> kafkaTemplate;

	private static final String TOPIC = "kafka_topic";

	@Override
	public Author addAuthor(Author authorinfo) {
		Author findByAuthorId = authorDao.findByAuthorId(authorinfo.getAuthorId());
		if (findByAuthorId == null) {
			GeneratePassword pwd = new GeneratePassword();
			String tempPassword = pwd.passwordGenerator(10);
			authorinfo.setPassword(tempPassword);
			Author author = authorDao.save(authorinfo);
			User user = new User();
			user.setUserName(author.getAuhthorName());
			user.setUserPassword(tempPassword);
			user.setUserRoles("ROLE_AUTHOR");
			userDao.save(user);
			emailService.sendEmail(author.getAuthorEmail(), "Spring Test Password",
					"new temporary Password: " + author.getPassword());
			return author;
		} else {
			throw new AuthorException("Author already exists!");
		}
	}

	@Override
	public ChangeAuthorPassword changePassword(ChangeAuthorPassword password) {
		Author author = authorDao.findByAuthorId(password.getAuthorId());
		if (author != null) {
			if (author.getPassword().equals(password.getCurrentPassword())) {
				if (password.getNewPassword().equals(password.getConfirmPassword())) {
					author.setPassword(password.getConfirmPassword());
					authorDao.save(author);
					User user = userDao.findByUserName(password.getUsername());
					user.setUserPassword(password.getConfirmPassword());
					userDao.save(user);
				} else {
					throw new AuthorException("New password not matching!");
				}
			} else {
				throw new AuthorException("Please enter the correct password!");
			}
		} else {
			throw new AuthorException("Author not found!");
		}

		return password;
	}

	@Override
	public BookShelf createBook(BookShelf shelf) {
		BookShelf bookShelf = shelfDao.save(shelf);

//		 int id = (int)(Math.floor(Math.random()*100));
//		kafkaTemplate.send(kafka_topic,
//				new BookShelf(id, "Java Microservices", "Mark Carl", (((id * 10) / 3) - 20) * 2));
//
//		return "Published successfully: " + LocalDateTime.now();

		if (bookShelf != null) {
			return bookShelf;
		} else {
			throw new AuthorException("Book was not added!");
		}
	}

	@Override
	public BookShelf updateBook(String authorId, String bookId, UpdateBook updateBook) {
		BookShelf findByBookIdAndAuthorBookId = shelfDao.findByBookIdAndAuthorBookId(bookId, authorId);
//		BookShelf shelf = new BookShelf();
		if (findByBookIdAndAuthorBookId != null && updateBook.getAuthorBookId() != null
				|| updateBook.getBookId() != null) {
			findByBookIdAndAuthorBookId.setBookStatus(updateBook.getBookStatus());
			findByBookIdAndAuthorBookId.setCategory(updateBook.getCategory());
			findByBookIdAndAuthorBookId.setContent(updateBook.getContent());
			findByBookIdAndAuthorBookId.setPrice(updateBook.getPrice());
			findByBookIdAndAuthorBookId.setTitle(updateBook.getBookTitle());
			findByBookIdAndAuthorBookId.setPublisher(updateBook.getPublisher());
			shelfDao.save(findByBookIdAndAuthorBookId);
			
			kafkaTemplate.send(TOPIC,
					new BookShelf(bookId, findByBookIdAndAuthorBookId.getBookStatus(),
							findByBookIdAndAuthorBookId.getCategory(), findByBookIdAndAuthorBookId.getContent(),
							findByBookIdAndAuthorBookId.getPrice(), findByBookIdAndAuthorBookId.getTitle(),
							findByBookIdAndAuthorBookId.getPublisher()));
			System.out.println("////////////////////////////////////////////////////////");
		} else {
			throw new AuthorException("Either the book or the author could not be found!");
		}
		return findByBookIdAndAuthorBookId;
	}

}
