package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.model.Book;
import org.modelmapper.ModelMapper;

public class MapperBook {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static BookDto toDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public static Book toEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }
}
