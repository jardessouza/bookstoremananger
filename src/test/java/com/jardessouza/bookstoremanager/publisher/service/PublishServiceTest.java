package com.jardessouza.bookstoremanager.publisher.service;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.model.pusblisherentity.entity.Publisher;
import com.jardessouza.bookstoremanager.model.pusblisherentity.mapper.PublisherMapper;
import com.jardessouza.bookstoremanager.model.pusblisherentity.repository.PublisherRepository;
import com.jardessouza.bookstoremanager.model.pusblisherentity.service.PublisherService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PublishServiceTest {
    @InjectMocks
    private PublisherService publisherService;

    @Mock
    private PublisherRepository publisherRepositoryMock;

    @BeforeEach
    void setUp(){
        BDDMockito.when(this.publisherRepositoryMock.save(ArgumentMatchers.any(Publisher.class)))
                .thenReturn(PublisherMapper.INSTANCE.toModel(PublisherDTO.builder().build()));
    }

    @Test
    void WhenSuccessfullyCreateReturnsPublisher(){
        PublisherDTO publisherToBeCreated = PublisherDTO.builder().build();
        PublisherDTO publisherCreate = this.publisherService.create(publisherToBeCreated);

        Assertions.assertThat(publisherCreate).isNotNull();
        Assertions.assertThat(publisherCreate.getName()).isEqualTo(publisherToBeCreated.getName());
        Assertions.assertThat(publisherCreate.getCode()).isEqualTo(publisherToBeCreated.getCode());
        Assertions.assertThat(publisherCreate.getFoundationDate()).isEqualTo(publisherToBeCreated.getFoundationDate());

    }
}
