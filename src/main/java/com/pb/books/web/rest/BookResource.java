package com.pb.books.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pb.books.dao.BookRepository;
import com.pb.books.model.Book;
import com.pb.books.model.BookDto;

@RestController
@RequestMapping("/api/books")
public class BookResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

	private final BookRepository bookRepository;

	public BookResource(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Book createBook(@Valid @RequestBody BookDto book) {
		LOGGER.info("Creating a new Book in the system.");
		return this.bookRepository.save(new Book.Builder().name(book.getName()).isbn(book.getIsbn())
				.price(book.getPrice()).authors(book.getAuthors()).build());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BookDto getBookById(final long id) {
		LOGGER.info("Fetching Book with the given ID: " + id);
		return this.bookRepository.findById(id)
				.map(book -> new BookDto(book.getName(), book.getPrice(), book.getIsbn(), book.getAuthors()))
				.orElse(null);
	}

}
