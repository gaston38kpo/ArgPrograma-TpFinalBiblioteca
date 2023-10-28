package com.ap.librarymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Book")
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
    private Boolean isDeleted;
    @OneToOne
    private Author author;
    @OneToOne
    private Editorial editorial;

    public Book(Long isbn, String title, Integer year, Integer copies, Integer borrowedCopies, Integer remainingCopies, Boolean isDeleted, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.isDeleted = isDeleted;
        this.author = author;
        this.editorial = editorial;
    }
}
