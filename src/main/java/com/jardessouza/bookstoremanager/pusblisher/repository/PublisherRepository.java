package com.jardessouza.bookstoremanager.pusblisher.repository;

import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
