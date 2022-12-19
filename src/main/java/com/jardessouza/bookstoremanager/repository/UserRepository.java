package com.jardessouza.bookstoremanager.repository;

import com.jardessouza.bookstoremanager.model.userentity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
