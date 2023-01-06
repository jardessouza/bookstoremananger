package com.jardessouza.bookstoremanager.books.dto;

import com.jardessouza.bookstoremanager.author.entity.Author;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;
    @NotNull
    @ISBN
    private String isbn;
    @NotNull
    @Max(3000)
    private Long pages;
    @NotNull
    @Max(100)
    private Integer chapters;
    @NotNull
    private Long authorId;
    @NotNull
    private Long publisherId;
}
