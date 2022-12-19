package com.jardessouza.bookstoremanager.model.userentity;

import com.jardessouza.bookstoremanager.model.booksentity.Book;
import com.jardessouza.bookstoremanager.model.entity.Auditable;
import com.jardessouza.bookstoremanager.model.pusblisherentity.Publisher;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
@ToString
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> book;
}
