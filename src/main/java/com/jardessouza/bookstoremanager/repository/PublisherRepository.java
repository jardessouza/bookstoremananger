package com.jardessouza.bookstoremanager.repository;

import com.jardessouza.bookstoremanager.model.pusblisherentity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
