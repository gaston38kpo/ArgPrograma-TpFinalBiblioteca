package com.ap.librarymanagement.dto;

import com.ap.librarymanagement.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private Boolean isEnabled;
    private Set<Book> bookList;
}
