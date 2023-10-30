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
public class EditorialDto {
    private Long id;
    private String name;
    private Boolean isEnabled;
    private Set<Book> bookList;

    public EditorialDto() {
        this.bookList = new HashSet<>();
    }
}
