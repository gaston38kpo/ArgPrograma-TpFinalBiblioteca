package com.ap.librarymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Long id;
    private String name;
    private Boolean isEnabled;

    @OneToMany(mappedBy = "editorial")
    private Set<Book> bookList;

    public Editorial() {
        this.isEnabled = true;
        this.bookList = new HashSet<>();
    }
}