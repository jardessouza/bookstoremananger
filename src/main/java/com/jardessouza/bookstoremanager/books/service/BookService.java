package com.jardessouza.bookstoremanager.books.service;

import com.jardessouza.bookstoremanager.author.entity.Author;
import com.jardessouza.bookstoremanager.author.service.AuthorService;
import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.books.exception.BookAlreadyExistsException;
import com.jardessouza.bookstoremanager.books.mapper.BookMapper;
import com.jardessouza.bookstoremanager.books.repository.BookRepository;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import com.jardessouza.bookstoremanager.pusblisher.service.PublisherService;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import com.jardessouza.bookstoremanager.user.entity.User;
import com.jardessouza.bookstoremanager.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    private final UserService userService;

    private final PublisherService publisherService;

    public BookResponseDTO create(AuthenticationUser authenticationUser, BookRequestDTO bookRequestDTO){

        User foundAuthenticatorUser = this.userService.verifyAndGetIfExists(authenticationUser.getUsername());
        verifyIfBookIsAlreadyRegistered(foundAuthenticatorUser, bookRequestDTO);
        Author foundAuthor = this.authorService.verifyAndGetIfExists(bookRequestDTO.getAuthorId());
        Publisher foundPublisher = this.publisherService.verifyAndGetIfExists(bookRequestDTO.getPublisherId());

        Book bookToSave = BookMapper.INSTANCE.toModel(bookRequestDTO);
        bookToSave.setUser(foundAuthenticatorUser);
        bookToSave.setAuthor(foundAuthor);
        bookToSave.setPublisher(foundPublisher);

        Book savedBook = this.bookRepository.save(bookToSave);

        return BookMapper.INSTANCE.toDTO(savedBook);
    }

    private void verifyIfBookIsAlreadyRegistered(User foundUser, BookRequestDTO bookRequestDTO) {
        this.bookRepository
                .findByNameAndIsbnAndUser(bookRequestDTO.getName(), bookRequestDTO.getIsbn(), foundUser)
                .ifPresent(duplicateBook -> {throw  new BookAlreadyExistsException(
                        bookRequestDTO.getName(), bookRequestDTO.getIsbn(), foundUser.getUsername());});
    }

}