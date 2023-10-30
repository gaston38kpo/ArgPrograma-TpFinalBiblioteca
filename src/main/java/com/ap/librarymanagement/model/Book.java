package com.ap.librarymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long isbn;
    private String title;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean isEnabled = true;

    @ManyToMany
    private Set<Author> authorList = new HashSet<>();

    @ManyToOne
    private Editorial editorial;

}
