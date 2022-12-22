package com.jardessouza.bookstoremanager.books.repository;

import com.jardessouza.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
