package com.jardessouza.bookstoremanager.publisher.builder;

import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public class PublisherDTOBuilder {
    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String name = "JS Editora";
    @Builder.Default
    private final String code = "AND155";
    @Builder.Default
    private final LocalDate foundationDate = LocalDate.of(2020, 6, 1);

    public PublisherDTO publisherDTO() {
        return new PublisherDTO(id, name, code, foundationDate);
    }

    public Publisher publisherCreate(){
        return Publisher.builder()
                .id(1L)
                .name("JS Editora")
                .code("AND155")
                .foundationDate(LocalDate.of(2020, 6, 1))
                .build();
    }
}
