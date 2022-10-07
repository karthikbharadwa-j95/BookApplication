package com.cts.digibook.author.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.digibook.dao.ShelfDao;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.service.AuthorServiceImplimentation;



@ExtendWith(MockitoExtension.class)
public class AuthorServiceImplimentationTest {

	@Mock
	private ShelfDao shelfDao;

	@InjectMocks
	private AuthorServiceImplimentation implimentation;

	// @Rule
	// public MockitoRule rule =
	// MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	@Test
	public void createBookTest() {

		// Change the strictness level only for this test method:
		// mockito.strictness(Strictness.LENIENT);

		BookShelf bookShelf = new BookShelf();
		bookShelf.setBookId("b0087");
		bookShelf.setAuthorBookId("auth10");
		bookShelf.setBookStatus(0);
		bookShelf.setCategory("comic");
		bookShelf.setContent("welcome");
		bookShelf.setPrice(9877.868);
		bookShelf.setPublisher("old school publications");
		bookShelf.setTitle("superman");

		Mockito.when(shelfDao.save(bookShelf)).thenReturn(bookShelf);

		assertThat(implimentation.createBook(bookShelf)).isEqualTo(bookShelf);
	}

}
