package com.jardessouza.bookstoremanager.model.booksentity.repository;

import com.jardessouza.bookstoremanager.model.booksentity.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
