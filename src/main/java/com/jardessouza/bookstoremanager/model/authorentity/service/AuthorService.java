package com.jardessouza.bookstoremanager.model.authorentity.service;

import com.jardessouza.bookstoremanager.model.authorentity.mapper.AuthorMapper;
import com.jardessouza.bookstoremanager.model.authorentity.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
