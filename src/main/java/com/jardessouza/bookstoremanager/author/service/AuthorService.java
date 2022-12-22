package com.jardessouza.bookstoremanager.author.service;

import com.jardessouza.bookstoremanager.author.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.jardessouza.bookstoremanager.author.exception.AuthorNotFoundException;
import com.jardessouza.bookstoremanager.author.mapper.AuthorMapper;
import com.jardessouza.bookstoremanager.author.repository.AuthorRepository;
import com.jardessouza.bookstoremanager.author.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO){
        verifyIfExists(authorDTO.getName());

        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = this.authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }

    public AuthorDTO findById(Long id){
        Author foundAuthor = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        return authorMapper.toDTO(foundAuthor);
    }

    public List<AuthorDTO> findAll(){
        return this.authorRepository.findAll()
                .stream().map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        AuthorDTO authorBeCreated = findById(id);
        Author author = authorMapper.toModel(authorBeCreated);
        this.authorRepository.delete(author);
    }

    private void verifyIfExists(String authorname) {
        this.authorRepository.findByName(authorname)
                .ifPresent(author -> {throw new AuthorAlreadyExistsException(authorname); });
    }




}
