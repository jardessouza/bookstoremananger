package com.jardessouza.bookstoremanager.model.pusblisherentity.mapper;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.model.pusblisherentity.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    public final static PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toModel(PublisherDTO publisherDTO);

    PublisherDTO toDTO(Publisher publisher);



}
