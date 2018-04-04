package com.pb.books.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pb.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findById(long id);

}
