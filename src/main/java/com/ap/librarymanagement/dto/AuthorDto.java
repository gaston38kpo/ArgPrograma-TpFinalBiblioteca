package com.ap.librarymanagement.dto;

import com.ap.librarymanagement.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private Boolean isEnabled;
    private Set<Book> bookList;

    public AuthorDto() {
        this.bookList = new HashSet<>();
        this.isEnabled = true;
    }
}
