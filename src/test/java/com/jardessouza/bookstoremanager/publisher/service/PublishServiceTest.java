package com.jardessouza.bookstoremanager.publisher.service;

import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import com.jardessouza.bookstoremanager.pusblisher.mapper.PublisherMapper;
import com.jardessouza.bookstoremanager.pusblisher.repository.PublisherRepository;
import com.jardessouza.bookstoremanager.pusblisher.service.PublisherService;
import com.jardessouza.bookstoremanager.publisher.builder.PublisherDTOBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class PublishServiceTest {
    @InjectMocks
    private PublisherService publisherService;

    @Mock
    private PublisherRepository publisherRepositoryMock;

    private PublisherDTOBuilder publisherDTOBuilder;

    @BeforeEach
    void setUp(){
        publisherDTOBuilder = PublisherDTOBuilder.builder().build();

        BDDMockito.when(this.publisherRepositoryMock.save(ArgumentMatchers.any(Publisher.class)))
                .thenReturn(PublisherMapper.INSTANCE.toModel(publisherDTOBuilder.publisherDTO()));

        BDDMockito.when(this.publisherRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(PublisherMapper.INSTANCE.toModel(publisherDTOBuilder.publisherDTO())));

        BDDMockito.when(this.publisherRepositoryMock.findAll())
                .thenReturn(List.of(publisherDTOBuilder.publisherCreate()));

        BDDMockito.doNothing().when(this.publisherRepositoryMock).delete(ArgumentMatchers.any(Publisher.class));
    }

    @Test
    void WhenSuccessfullyCreateReturnsPublisher(){
        PublisherDTO publisherToBeCreated = publisherDTOBuilder.publisherDTO();
        PublisherDTO publisherCreate = this.publisherService.create(publisherToBeCreated);

        Assertions.assertThat(publisherCreate).isNotNull();
        Assertions.assertThat(publisherCreate.getName()).isEqualTo(publisherToBeCreated.getName());
        Assertions.assertThat(publisherCreate.getCode()).isEqualTo(publisherToBeCreated.getCode());
        Assertions.assertThat(publisherCreate.getFoundationDate()).isEqualTo(publisherToBeCreated.getFoundationDate());

    }

    @Test
    void WhenSuccessfullyFindIdReturnsPublisher(){

        PublisherDTO expectedPublisher = this.publisherService.findById(1L);

        Assertions.assertThat(expectedPublisher.getId()).isNotNull();
        Assertions.assertThat(expectedPublisher.getId()).isEqualTo(1L);
    }

    @Test
    void WhenSuccessfullyReturnsListedPublishers(){
        List<PublisherDTO> publishersListed = this.publisherService.findAll();

        Assertions.assertThat(publishersListed)
                .isNotEmpty()
                .isNotNull()
                .hasSize(1);
        Assertions.assertThat(publishersListed.get(0).getName()).isEqualTo("JS Editora");
        Assertions.assertThat(publishersListed.get(0).getCode()).isEqualTo("AND155");
    }

    @Test
    void WhenIdIsDeletedSuccessfully(){
        Assertions.assertThatCode(() -> this.publisherService.delete(1L))
                .doesNotThrowAnyException();
    }

}
