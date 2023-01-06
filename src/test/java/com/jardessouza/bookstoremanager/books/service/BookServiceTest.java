package com.jardessouza.bookstoremanager.books.service;

import com.jardessouza.bookstoremanager.author.entity.Author;
import com.jardessouza.bookstoremanager.author.service.AuthorService;
import com.jardessouza.bookstoremanager.books.builder.BookRequestDTOBuilder;
import com.jardessouza.bookstoremanager.books.builder.BookResponseDTOBuilder;
import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.books.mapper.BookMapper;
import com.jardessouza.bookstoremanager.books.repository.BookRepository;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import com.jardessouza.bookstoremanager.pusblisher.service.PublisherService;
import com.jardessouza.bookstoremanager.user.builder.UserDTOBuilder;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import com.jardessouza.bookstoremanager.user.entity.User;
import com.jardessouza.bookstoremanager.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {

    private final BookMapper bookMapper = BookMapper.INSTANCE;
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepositoryMock;
    @Mock
    private AuthorService authorService;
    @Mock
    private UserService userService;
    @Mock
    private PublisherService publisherService;
    private BookRequestDTOBuilder bookRequestDTOBuilder;
    private BookResponseDTOBuilder bookResponseDTOBuilder;
    private AuthenticationUser authenticationUser;

    @BeforeEach
    void SetUp() {
        bookRequestDTOBuilder = BookRequestDTOBuilder.builder().build();
        bookResponseDTOBuilder = BookResponseDTOBuilder.builder().build();
        authenticationUser = new AuthenticationUser("jardessouza", "123456", "ADMIN");

        BDDMockito.when(this.userService.verifyAndGetIfExists(authenticationUser.getUsername())).thenReturn(new User());

        BDDMockito.when(this.bookRepositoryMock.findByNameAndIsbnAndUser(
                ArgumentMatchers.eq(bookRequestDTOBuilder.buildRequestBookDTO().getName()),
                ArgumentMatchers.eq(bookRequestDTOBuilder.buildRequestBookDTO().getIsbn()),
                ArgumentMatchers.any()
        )).thenReturn(Optional.empty());

        BDDMockito.when(this.authorService.verifyAndGetIfExists(bookRequestDTOBuilder.buildRequestBookDTO().getAuthorId()))
                .thenReturn(new Author());

        BDDMockito.when(this.publisherService.verifyAndGetIfExists(bookRequestDTOBuilder.buildRequestBookDTO().getPublisherId()))
                .thenReturn(new Publisher());

        BDDMockito.when(this.bookRepositoryMock.save(ArgumentMatchers.any(Book.class)))
                .thenReturn(bookMapper.toModel(bookRequestDTOBuilder.buildRequestBookDTO()));

        BDDMockito.when(this.bookRepositoryMock.findByIdAndUser(
                ArgumentMatchers.eq(bookRequestDTOBuilder.buildRequestBookDTO().getId()),
                ArgumentMatchers.any(User.class)))
                .thenReturn(Optional.of(bookMapper.toModel(bookRequestDTOBuilder.buildRequestBookDTO())));
        
        BDDMockito.when(this.bookRepositoryMock.findAllByUser(ArgumentMatchers.any(User.class)))
                .thenReturn(Collections.singletonList(bookMapper.toModel(bookRequestDTOBuilder.buildRequestBookDTO())));

        BDDMockito.doNothing().when(this.bookRepositoryMock).deleteByIdAndUser(
                ArgumentMatchers.eq(bookRequestDTOBuilder.buildRequestBookDTO().getId()),
                ArgumentMatchers.any(User.class));
    }

    @Test
    void WhenCreateAndGetSuccessReturnsAuthor() {
        BookRequestDTO expectedBookRequestToCreateDTO = bookRequestDTOBuilder.buildRequestBookDTO();
        BookResponseDTO expectedCreatedBookDTO = bookResponseDTOBuilder.buildBookResponse();

        BookResponseDTO createdBookResponseDTO = this.bookService.create(authenticationUser, expectedBookRequestToCreateDTO);
        setAuthorAndPublisher(expectedCreatedBookDTO, createdBookResponseDTO);

        Assertions.assertThat(createdBookResponseDTO).isNotNull();
        Assertions.assertThat(createdBookResponseDTO).isEqualTo(expectedCreatedBookDTO);
    }

    @Test
    void WhenFindingIdAndUserSuccessfullyReturnsBook(){
        BookRequestDTO expectedBookRequestToCreateDTO = bookRequestDTOBuilder.buildRequestBookDTO();
        BookResponseDTO expectedCreatedBookDTO = bookResponseDTOBuilder.buildBookResponse();

        BookResponseDTO createdFindByIdAndUser = this.bookService
                .findByIdAndUser(authenticationUser, expectedBookRequestToCreateDTO.getAuthorId());
        setAuthorAndPublisher(expectedCreatedBookDTO, createdFindByIdAndUser);

        Assertions.assertThat(createdFindByIdAndUser).isNotNull();
        Assertions.assertThat(createdFindByIdAndUser).isEqualTo(expectedCreatedBookDTO);
    }

    @Test
    void whenListBookIsCalledThenItShouldBeReturned(){
        BookResponseDTO expectedCreatedBookDTO = bookResponseDTOBuilder.buildBookResponse();

        List<BookResponseDTO> returnedBooksResponseList  = this.bookService.findAllByUser(authenticationUser);
        setAuthorAndPublisher(expectedCreatedBookDTO, returnedBooksResponseList.get(0));

        Assertions.assertThat(returnedBooksResponseList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(returnedBooksResponseList.get(0)).isEqualTo(expectedCreatedBookDTO);
    }

    @Test
    void whenExistingBookIdIsInformedThenItShouldBeDeleted(){
        BookRequestDTO expectedBookRequestToCreateDTO = bookRequestDTOBuilder.buildRequestBookDTO();

        Assertions.assertThatCode(() -> this.bookService
                .deleteByIdAndUser(authenticationUser, expectedBookRequestToCreateDTO.getId()))
                .doesNotThrowAnyException();
    }

    @Test
    void whenExistingBookIdIsInformedThenItShouldBeUpdated(){
        BookRequestDTO expectedBookRequestToCreateDTO = bookRequestDTOBuilder.buildRequestBookDTO();

        Assertions.assertThatCode(() -> this.bookService.updateIdAndUser(
                authenticationUser, 1L, expectedBookRequestToCreateDTO )).doesNotThrowAnyException();
    }

    @Test

    private static void setAuthorAndPublisher(BookResponseDTO expectedCreatedBookDTO, BookResponseDTO createdBookResponseDTO) {
        createdBookResponseDTO.setAuthor(expectedCreatedBookDTO.getAuthor());
        createdBookResponseDTO.setPublisher(expectedCreatedBookDTO.getPublisher());
    }



}
