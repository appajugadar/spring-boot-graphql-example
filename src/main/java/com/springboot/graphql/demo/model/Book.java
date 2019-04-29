package com.springboot.graphql.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    private Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
}
