package com.ap.librarymanagement.dto;

import com.ap.librarymanagement.model.Author;
import com.ap.librarymanagement.model.Editorial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private Long isbn;
    private String title;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean isEnabled;
    private Author author;
    private Editorial editorial;
}
