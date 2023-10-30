package com.ap.librarymanagement.dto;

import com.ap.librarymanagement.model.Author;
import com.ap.librarymanagement.model.Editorial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private Long isbn;
    private String title;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean isEnabled;
    private Set<Author> authorList;
    private Editorial editorial;
}
