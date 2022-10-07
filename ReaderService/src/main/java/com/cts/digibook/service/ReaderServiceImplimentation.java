package com.cts.digibook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.digibook.dao.ReaderDao;
import com.cts.digibook.dao.ShelfDao;
import com.cts.digibook.dao.SubscriptionDao;
import com.cts.digibook.dto.BooksDto;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.entity.Reader;
import com.cts.digibook.entity.Subscription;
import com.cts.digibook.exception.ReaderException;
import com.cts.digibook.passwordgenerator.GeneratePassword;

@Service
public class ReaderServiceImplimentation implements ReaderService {

	@Autowired
	private ReaderDao readerDao;

	@Autowired
	private ShelfDao shelfDao;

//	@Autowired
//	private UserDao userDao;

	@Autowired
	private SubscriptionDao subscriptionDao;

	@Autowired
	private EmailService emailService;

	@Override
	public Reader addReader(Reader readerInfo) {
		Reader findByReaderId = readerDao.findByReaderId(readerInfo.getReaderId());
		if (findByReaderId == null) {
			GeneratePassword pwd = new GeneratePassword();
			String tempPassword = pwd.passwordGenerator(10);
			readerInfo.setPassword(tempPassword);
			Reader reader = readerDao.save(readerInfo);
//			User user = new User();
//			user.setUserName(reader.getReaderName());
//			user.setUserPassword(tempPassword);
//			user.setUserRoles("ROLE_READER");
//			userDao.save(user);
			emailService.sendEmail(reader.getReaderEmail(), "Spring Test Password",
					"new temporary Password: " + reader.getPassword());
			return reader;
		} else {
			throw new ReaderException("Reader already exists!");
		}
	}

	@Override
	public Subscription bookSubscription(Subscription subscription) {
		BookShelf byBookId = shelfDao.findByBookId(subscription.getSubBookId());
		Reader byReaderId = readerDao.findByReaderId(subscription.getSubReaderId());
		if (byBookId != null) {
			if (byReaderId != null) {
				subscription.setSubBookId(byBookId.getBookId());
				subscription.setSubBookName(byBookId.getTitle());
				subscription.setSubReaderEmail(byReaderId.getReaderEmail());
				subscription.setSubReaderId(byReaderId.getReaderId());
				subscriptionDao.save(subscription);
				emailService.sendEmail(subscription.getSubReaderEmail(), "Thank you for subscribing the book",
						"Your Book Name is: " + subscription.getSubBookName());
			} else {
				throw new ReaderException("Reader not found!");
			}
		} else {
			throw new ReaderException("Book not found!");
		}
		return subscription;
	}

	@Override
	public BooksDto fetchBooks(String readerId) {
		List<Subscription> findBySubReaderId = subscriptionDao.findBySubReaderId(readerId);
		if (findBySubReaderId != null) {
			List<String> list1 = new ArrayList();
			for (Subscription subscription : findBySubReaderId) {
				list1.add(subscription.getSubBookId());
			}
			List<BookShelf> bookShelfs = new ArrayList<BookShelf>();
			for (String bookShelf : list1) {
				bookShelfs.add(shelfDao.findByBookId(bookShelf));
			}
			BooksDto booksDto = new BooksDto();
			booksDto.setReadersBooks(bookShelfs);
			booksDto.setReaderId(readerId);

			return booksDto;
		} else {
			throw new ReaderException("please subscribe!");
		}

//	return bookShelfs;
//	if(findBySubReaderId==null) {
//		throw new BookAppException("Reader not found!");
//	}
//	else {
//	}
//	Subscription subscribers = new Subscription();
//		BooksDto listOfBooks = new BooksDto();
//		listOfBooks.setReaderId(readerId);
//		listOfBooks.setReadersBooks(subscribers.);
	}
//		Reader byReaderId = readerDao.findByReaderId(readerId);
//		if(byReaderId==null) {
//			throw new BookAppException("Reader not found!");
//		}else {
//			
//		}
//			return subscriptionDao.findBySubReaderId(readerId).stream().map(this::convertEntityToDto).collect(Collectors.toList());
//		}
//	
//
//	public BooksDto convertEntityToDto(Subscription subscribers) {
//		BooksDto dto = new BooksDto();
//		dto.setReaderId(subscribers.getSubReaderId());
//		dto.setReadersBooks(subscribers.getSubBookName());
//		return dto;
//	}
//	}

	@Override
	public BookShelf readBook(String readerEmail, String bookId) {
		BookShelf findByBookId = shelfDao.findByBookId(bookId);
		Reader findByReaderEmail = readerDao.findByReaderEmail(readerEmail);
		if (findByBookId != null) {
			if (findByReaderEmail != null) {
				findByBookId.getBookId();
				findByBookId.getTitle();
				findByBookId.getCategory();
				findByBookId.getContent();
			} else {
				throw new ReaderException("Enter valid Reader Id!");
			}
		} else {
			throw new ReaderException("Book not found!");
		}
		return findByBookId;
	}

	@Override
	public BookShelf fetchBySubId(String subId) {
		Subscription subBookId = subscriptionDao.findBySubscriptionId(subId);
		BookShelf findByBookId = shelfDao.findByBookId(subBookId.getSubBookId());
		if (findByBookId != null) {
			findByBookId.getBookId();
			findByBookId.getTitle();
			findByBookId.getPublisher();
		} else {
			throw new ReaderException("please subscribe to proceed!");
		}
		return findByBookId;

	}

}