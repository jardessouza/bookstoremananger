package com.jardessouza.bookstoremanager.model.pusblisherentity.entity;

import com.jardessouza.bookstoremanager.model.booksentity.entity.Book;
import com.jardessouza.bookstoremanager.model.entity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> book;

}
