package com.cts.digibook.dto;

import java.util.List;


import org.springframework.stereotype.Component;

import com.cts.digibook.entity.BookShelf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {

	private String readerId;
	private List<BookShelf> readersBooks;
}
