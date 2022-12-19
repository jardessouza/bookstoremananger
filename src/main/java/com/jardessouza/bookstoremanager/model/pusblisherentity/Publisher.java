package com.jardessouza.bookstoremanager.model.pusblisherentity;

import com.jardessouza.bookstoremanager.model.booksentity.Book;
import com.jardessouza.bookstoremanager.model.entity.Auditable;
import com.jardessouza.bookstoremanager.model.userentity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_PUBLISHERS")
@Getter
@Setter
@ToString
public class Publisher extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = false, length = 100)
    private String code;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> book;

}
