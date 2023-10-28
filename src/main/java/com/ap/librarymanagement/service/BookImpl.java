package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookImpl implements IBook {

    private BookRepository bookRepository;

    @Override
    public List<BookDto> findAll() {
        return null;
    }

    @Override
    public String save(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto find(String surname) {
        return null;
    }

    @Override
    public BookDto find(Long id) {
        return null;
    }

    @Override
    public String update(Long id, BookDto bookDto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
