package com.jardessouza.bookstoremanager.author.builder;

import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.model.authorentity.entity.Author;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String name = "Jardes Souza";
    @Builder.Default
    private final int age = 32;

    public AuthorDTO buildAuthorDTO(){
        return new AuthorDTO(id, name, age);
    }
    public Author buildAuthor(){
        return Author.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}