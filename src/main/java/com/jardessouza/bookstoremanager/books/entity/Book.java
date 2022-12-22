package com.jardessouza.bookstoremanager.books.entity;

import com.jardessouza.bookstoremanager.author.entity.Author;
import com.jardessouza.bookstoremanager.entity.Auditable;
import com.jardessouza.bookstoremanager.pusblisher.entity.Publisher;
import com.jardessouza.bookstoremanager.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TB_BOOKS")
@Getter
@Setter
@ToString
public class Book extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String isbn;

    @Column(columnDefinition = "integer default 0")
    private int pages;

    @Column(columnDefinition = "integer default 0")
    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;
}
