package com.pb.books.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {
	private final @NotNull @NotEmpty String name;
	private final double price;
	private final String isbn;
	private final @NotNull @NotEmpty List<@NotNull @NotEmpty String> authors;

	@JsonCreator
	public BookDto(@JsonProperty("name") String name, @JsonProperty("price") double price,
			@JsonProperty("isbn") String isbn, @JsonProperty("authors") List<String> authors) {
		super();
		this.name = name;
		this.price = price;
		this.isbn = isbn;
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getIsbn() {
		return isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

}
