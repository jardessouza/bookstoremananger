package com.jardessouza.bookstoremanager.repository;

import com.jardessouza.bookstoremanager.model.authorentity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
