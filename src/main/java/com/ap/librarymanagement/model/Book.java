package com.ap.librarymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private Long isbn;
    private String title;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean isEnabled;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authorList;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Book() {
        this.isEnabled = true;
        this.authorList = new HashSet<>();
    }
}
