package com.jardessouza.bookstoremanager.model.pusblisherentity.service;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.model.pusblisherentity.entity.Publisher;
import com.jardessouza.bookstoremanager.model.pusblisherentity.mapper.PublisherMapper;
import com.jardessouza.bookstoremanager.model.pusblisherentity.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherDTO create(PublisherDTO publisherDTO){
        Publisher publisherToBeCreated = PublisherMapper.INSTANCE.toModel(publisherDTO);
        Publisher publisherCreated = this.publisherRepository.save(publisherToBeCreated);
        return PublisherMapper.INSTANCE.toDTO(publisherCreated);
    }

}
