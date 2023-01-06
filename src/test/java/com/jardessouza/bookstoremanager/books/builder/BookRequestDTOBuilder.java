package com.jardessouza.bookstoremanager.books.builder;

import com.jardessouza.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.publisher.builder.PublisherDTOBuilder;
import com.jardessouza.bookstoremanager.user.builder.UserDTOBuilder;
import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import lombok.Builder;

@Builder
public class BookRequestDTOBuilder {
    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Spring Boot Pro";

    @Builder.Default
    private final String isbn = "978-3-16-148410-0";

    @Builder.Default
    private final Long publisherId = 1L;

    @Builder.Default
    private final Long authorId = 1L;

    @Builder.Default
    private final Long pages = 200L;

    @Builder.Default
    private final Integer chapters = 10;

    private final UserDTO userDTO = UserDTOBuilder.builder().build().builderUserDTO();

    private final PublisherDTOBuilder publisherDTOBuilder;

    private final AuthorDTOBuilder authorDTOBuilder;

    public BookRequestDTO buildRequestBookDTO() {
        return new BookRequestDTO(id,
                name,
                isbn,
                pages,
                chapters,
                publisherId,
                authorId);
    }

    public Book createBook(){
        return Book.builder()
                .id(id)
                .name(name)
                .isbn(isbn)
                .pages(pages)
                .chapters(chapters)
                .publisher(publisherDTOBuilder.publisherCreate())
                .author(authorDTOBuilder.buildAuthorCreator())
                .build();
    }
}
