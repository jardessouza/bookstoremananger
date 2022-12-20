package com.jardessouza.bookstoremanager.author.service;

import com.jardessouza.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.model.authorentity.entity.Author;
import com.jardessouza.bookstoremanager.model.authorentity.exception.AuthorAlreadyExistsException;
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


}
