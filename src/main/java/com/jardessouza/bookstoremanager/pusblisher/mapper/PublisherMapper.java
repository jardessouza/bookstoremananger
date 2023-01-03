package com.jardessouza.bookstoremanager.pusblisher.mapper;

import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toModel(PublisherDTO publisherDTO);

    PublisherDTO toDTO(Publisher publisher);



}
