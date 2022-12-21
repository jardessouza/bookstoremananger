package com.jardessouza.bookstoremanager.model.pusblisherentity.service;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.model.pusblisherentity.entity.Publisher;
import com.jardessouza.bookstoremanager.model.pusblisherentity.exception.PublishNotFoundException;
import com.jardessouza.bookstoremanager.model.pusblisherentity.mapper.PublisherMapper;
import com.jardessouza.bookstoremanager.model.pusblisherentity.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherDTO create(PublisherDTO publisherDTO){
        Publisher publisherToBeCreated = PublisherMapper.INSTANCE.toModel(publisherDTO);
        Publisher publisherCreated = this.publisherRepository.save(publisherToBeCreated);
        return PublisherMapper.INSTANCE.toDTO(publisherCreated);
    }

    public PublisherDTO findById(Long id){
        Publisher publisher = this.publisherRepository.findById(id)
                .orElseThrow(() -> new PublishNotFoundException(id));
        return PublisherMapper.INSTANCE.toDTO(publisher);
    }

    public List<PublisherDTO> findAll(){
        return this.publisherRepository.findAll()
                .stream().map(PublisherMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        PublisherDTO publisherToBeFound = findById(id);
        Publisher publisherFound = PublisherMapper.INSTANCE.toModel(publisherToBeFound);
        this.publisherRepository.delete(publisherFound);
    }

}
