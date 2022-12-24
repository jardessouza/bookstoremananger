package com.jardessouza.bookstoremanager.user.entity;

import com.jardessouza.bookstoremanager.books.entity.Book;
import com.jardessouza.bookstoremanager.entity.Auditable;
import com.jardessouza.bookstoremanager.user.enums.Gender;
import com.jardessouza.bookstoremanager.user.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
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

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
