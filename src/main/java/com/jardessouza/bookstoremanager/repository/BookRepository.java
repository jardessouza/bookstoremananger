package com.jardessouza.bookstoremanager.repository;

import com.jardessouza.bookstoremanager.model.booksentity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
