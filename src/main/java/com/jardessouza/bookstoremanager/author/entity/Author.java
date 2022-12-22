package com.jardessouza.bookstoremanager.author.entity;

import com.jardessouza.bookstoremanager.entity.Auditable;
import com.jardessouza.bookstoremanager.books.entity.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_AUTHORS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "integer default 0")
    private int age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> book;

}
