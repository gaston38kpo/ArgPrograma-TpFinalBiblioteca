package com.ap.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    private String name;
    private Boolean isEnabled;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "authorList")
    @JsonIgnore
    private Set<Book> bookList = new HashSet<>();

    public Author() {
        this.isEnabled = true;
    }
}
