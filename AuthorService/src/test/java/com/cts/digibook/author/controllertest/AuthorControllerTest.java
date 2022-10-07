package com.cts.digibook.author.controllertest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.digibook.controller.AuthorController;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.service.AuthorServiceImplimentation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = AuthorController.class)
public class AuthorControllerTest {
	
	@InjectMocks
	private AuthorController authorController;

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private AuthorServiceImplimentation serviceImplimentation;

	@Test
	public void createBookTest() throws Exception {
		BookShelf bookShelf = new BookShelf();
		bookShelf.setBookId("b0087");
		bookShelf.setAuthorBookId("auth10");
		bookShelf.setBookStatus(0);
		bookShelf.setCategory("comic");
		bookShelf.setContent("welcome");
		bookShelf.setPrice(9877.868);
		bookShelf.setPublisher("old school publications");
		bookShelf.setTitle("superman");

		String inputInJson = this.mapToJson(bookShelf);

		String URI = "/api/v1/digitalbooks/authors/books";

		String expectedJson = this.mapToJson(bookShelf);

		Mockito.when(serviceImplimentation.createBook(Mockito.any(BookShelf.class))).thenReturn(bookShelf);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	// this method maps an object into JSON string by using jackson objectmapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
