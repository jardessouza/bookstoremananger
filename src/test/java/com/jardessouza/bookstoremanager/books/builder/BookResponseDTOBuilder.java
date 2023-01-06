package com.jardessouza.bookstoremanager.books.builder;

import com.jardessouza.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.jardessouza.bookstoremanager.author.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.publisher.builder.PublisherDTOBuilder;
import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.user.builder.UserDTOBuilder;
import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import lombok.Builder;

@Builder
public class BookResponseDTOBuilder {
    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Spring Boot Pro";

    @Builder.Default
    private final String isbn = "978-3-16-148410-0";

    @Builder.Default
    private final PublisherDTO publisher = PublisherDTOBuilder.builder().build().buildPublisherDTO();

    @Builder.Default
    private final AuthorDTO author = AuthorDTOBuilder.builder().build().buildAuthorDTO();

    @Builder.Default
    private final Long pages = 200L;

    @Builder.Default
    private final Integer chapters = 10;

    private final UserDTO userDTO = UserDTOBuilder.builder().build().builderUserDTO();

    private final PublisherDTOBuilder publisherDTOBuilder;

    private final AuthorDTOBuilder authorDTOBuilder;

    public BookResponseDTO buildBookResponse(){
        return new BookResponseDTO(id,
                name,
                isbn,
                pages,
                chapters,
                author,
                publisher
        );
    }

    public com.jardessouza.bookstoremanager.books.entity.Book createBook(){
        return Book.builder()
                .name(name)
                .isbn(isbn)
                .pages(pages)
                .chapters(chapters)
                .author(authorDTOBuilder.buildAuthorCreator())
                .publisher(publisherDTOBuilder.publisherCreate())
                .build();
    }


}
