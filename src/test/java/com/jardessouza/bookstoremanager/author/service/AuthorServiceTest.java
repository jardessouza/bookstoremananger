package com.jardessouza.bookstoremanager.author.service;

import com.jardessouza.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.model.authorentity.entity.Author;
import com.jardessouza.bookstoremanager.model.authorentity.exception.AuthorAlreadyExistsException;
import com.jardessouza.bookstoremanager.model.authorentity.exception.AuthorNotFoundException;
import com.jardessouza.bookstoremanager.model.authorentity.mapper.AuthorMapper;
import com.jardessouza.bookstoremanager.model.authorentity.repository.AuthorRepository;
import com.jardessouza.bookstoremanager.model.authorentity.service.AuthorService;
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
public class AuthorServiceTest {
    
    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepositoryMock;

    private AuthorDTOBuilder authorDTOBuilder;
    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();

        BDDMockito.when(this.authorRepositoryMock.save(ArgumentMatchers.any(Author.class)))
                .thenReturn(authorMapper.toModel(authorDTOBuilder.buildAuthorDTO()));

        BDDMockito.when(this.authorRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(authorMapper.toModel(authorDTOBuilder.buildAuthorDTO())));

        BDDMockito.when(this.authorRepositoryMock.findAll())
                .thenReturn(List.of(authorDTOBuilder.buildAuthor()));

    }

    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated() {
        AuthorDTO ExpectedAuthorToCreatedDTO = this.authorDTOBuilder.buildAuthorDTO();
        AuthorDTO createdAuthorDTO = this.authorService.create(ExpectedAuthorToCreatedDTO);

        Assertions.assertThat(createdAuthorDTO)
                .isNotNull()
                .isNotIn(AuthorAlreadyExistsException.class);
        Assertions.assertThat(createdAuthorDTO).isEqualTo(ExpectedAuthorToCreatedDTO);
        Assertions.assertThat(createdAuthorDTO.getName()).isEqualTo(ExpectedAuthorToCreatedDTO.getName());
        Assertions.assertThat(createdAuthorDTO.getAge()).isEqualTo(ExpectedAuthorToCreatedDTO.getAge());
    }

    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {

        BDDMockito.when(this.authorRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(authorMapper.toModel(authorDTOBuilder.buildAuthorDTO())));

        Assertions.assertThatExceptionOfType(AuthorAlreadyExistsException.class)
                .isThrownBy(() -> this.authorService.create(authorDTOBuilder.buildAuthorDTO()));

    }
    @Test
    void whenValidIdIsGivenTheAnAuthorShouldBeReturned(){

        AuthorDTO ExpectedAuthor = this.authorService.findById(1L);

        Assertions.assertThat(ExpectedAuthor.getId()).isNotNull();
        Assertions.assertThat(ExpectedAuthor.getId()).isEqualTo(1L);

    }

    @Test
    void whenIdIsNotFoundItReturnsNotFoundException(){
        BDDMockito.when(this.authorRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(AuthorNotFoundException.class)
                .isThrownBy(() -> this.authorService.findById(1L));

    }

    @Test
    void whenListAuthorsIsCalledThenItShouldBeReturned(){

        List<AuthorDTO> authorsListCreate = this.authorService.findAll();

        Assertions.assertThat(authorsListCreate)
                .isNotEmpty()
                .isNotNull()
                .hasSize(1);

        Assertions.assertThat(authorsListCreate.get(0).getName()).isEqualTo("Jardes Souza");
        Assertions.assertThat(authorsListCreate.get(0).getAge()).isEqualTo(32);
    }

    @Test
    void whenListAuthorsIsCalledThenItEmptyListShouldBeReturned(){
        BDDMockito.when(this.authorRepositoryMock.findAll())
                .thenReturn(Collections.emptyList());

        List<AuthorDTO> authorsListCreate = this.authorService.findAll();

        Assertions.assertThat(authorsListCreate).isEmpty();
        Assertions.assertThat(authorsListCreate).hasSize(0);

    }


}
