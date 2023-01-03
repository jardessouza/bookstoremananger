package com.jardessouza.bookstoremanager.books.repository;

import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByNameAndIsbnAndUser(String name, String isbn, User user);
    Optional<Book> findByIdAndUser(Long id, User user);

}
