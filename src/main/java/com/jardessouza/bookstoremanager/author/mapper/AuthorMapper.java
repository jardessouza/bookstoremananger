package com.jardessouza.bookstoremanager.author.mapper;

import com.jardessouza.bookstoremanager.author.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.author.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    public abstract Author toModel(AuthorDTO authorDTO);

    public abstract AuthorDTO toDTO(Author author);
}
