package com.jardessouza.bookstoremanager.model.userentity.repository;

import com.jardessouza.bookstoremanager.model.userentity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
