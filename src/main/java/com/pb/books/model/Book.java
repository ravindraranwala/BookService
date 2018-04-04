package com.pb.books.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private String isbn;
	@ElementCollection(targetClass = String.class)
	private List<String> authors;

	// Needed by Hibernate framework.
	public Book() {
		super();
	}

	public Book(Builder builder) {
		super();
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
		this.isbn = builder.isbn;
		this.authors = builder.authors;
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

	public long getId() {
		return id;
	}

	public static class Builder {
		private long id;
		private String name;
		private double price;
		private String isbn;
		private List<String> authors;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder price(double price) {
			this.price = price;
			return this;
		}

		public Builder isbn(String isbn) {
			this.isbn = isbn;
			return this;
		}

		public Builder authors(List<String> authors) {
			this.authors = authors;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}

}
