package com.jardessouza.bookstoremanager.pusblisher.entity;

import com.jardessouza.bookstoremanager.entity.Auditable;
import com.jardessouza.bookstoremanager.books.entity.Book;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_PUBLISHERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
