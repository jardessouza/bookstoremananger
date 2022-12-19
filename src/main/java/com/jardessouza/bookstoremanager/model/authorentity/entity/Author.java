package com.jardessouza.bookstoremanager.model.authorentity.entity;

import com.jardessouza.bookstoremanager.model.booksentity.entity.Book;
import com.jardessouza.bookstoremanager.model.entity.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_AUTHORS")
@Getter
@Setter
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
