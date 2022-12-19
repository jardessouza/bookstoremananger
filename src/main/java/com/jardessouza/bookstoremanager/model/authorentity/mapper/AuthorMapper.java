package com.jardessouza.bookstoremanager.model.authorentity.mapper;

import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.model.authorentity.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    public abstract Author toModel(AuthorDTO authorDTO);

    public abstract AuthorDTO toDTO(Author author);
}
