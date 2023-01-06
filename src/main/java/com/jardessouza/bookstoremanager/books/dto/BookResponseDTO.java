package com.jardessouza.bookstoremanager.books.dto;

import com.jardessouza.bookstoremanager.author.dto.AuthorDTO;
import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private Long id;

    private String name;

    private String isbn;

    private Long pages;

    private Integer chapters;

    private AuthorDTO author;

    private PublisherDTO publisher;
}
