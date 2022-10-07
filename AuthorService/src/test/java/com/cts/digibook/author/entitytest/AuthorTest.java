package com.cts.digibook.author.entitytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.cts.digibook.entity.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthorTest {

	ObjectMapper mapper = new ObjectMapper();
	String json = "{\"authorId\":\"auth02\",\"auhthorName\":\"chandra\",\"authorEmail\":\"chandra@gmail.com\","
			+ "\"authorGender\":\"M\",\"isAccountActive\":0,\"username\":\"chandra123\",\"password\":\"chandra@123\"}";

	@Test
	void serializeTest() throws JsonProcessingException {
		// Author author = new
		// Author("auth02","chandra","chandra@gmail.com","M",0,"chandra123","chandra@123");
		// System.out.println(mapper.writeValueAsString(author));
		Author author = mapper.readValue(json, Author.class);
		String string = mapper.writeValueAsString(author);
		assertNotEquals(author, string);
	}

	@Test
	void deserializeTest() throws JsonMappingException, JsonProcessingException {
		Author auth = mapper.readValue(json, Author.class);
		assertEquals("auth02", auth.getAuthorId());
		assertEquals("chandra", auth.getAuhthorName());
		assertEquals("chandra@gmail.com", auth.getAuthorEmail());
		assertEquals("M", auth.getAuthorGender());
		assertEquals(0, auth.getIsAccountActive());
		assertEquals("chandra123", auth.getUsername());
		assertEquals("chandra@123", auth.getPassword());

	}
}
