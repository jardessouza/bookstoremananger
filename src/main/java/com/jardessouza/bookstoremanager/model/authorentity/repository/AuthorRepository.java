package com.jardessouza.bookstoremanager.model.authorentity.repository;

import com.jardessouza.bookstoremanager.model.authorentity.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
