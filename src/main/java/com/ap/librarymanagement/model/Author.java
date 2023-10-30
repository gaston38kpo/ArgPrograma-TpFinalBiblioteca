package com.ap.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToMany
    private Set<Book> bookList;

    public Author() {
        this.isEnabled = true;
        this.bookList = new HashSet<>();
    }
}
