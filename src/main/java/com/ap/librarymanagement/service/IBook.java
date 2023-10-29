package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.BookDto;

import java.util.List;

public interface IBook {

    List<BookDto> findAll();

    String save(BookDto bookDto);

    BookDto find(String title);

    BookDto find(Long id);

    String update(Long id, BookDto bookDto);

    String delete(Long id);

    String restore(Long id);
}
