package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.model.Book;

public class MapperBook {
    public static BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();

        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        bookDto.setCopies(book.getCopies());
        bookDto.setBorrowedCopies(book.getBorrowedCopies());
        bookDto.setRemainingCopies(book.getRemainingCopies());
        bookDto.setIsEnabled(book.getIsEnabled());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setEditorial(book.getEditorial());

        return bookDto;
    }

    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();

        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setCopies(bookDto.getCopies());
        book.setBorrowedCopies(bookDto.getBorrowedCopies());
        book.setRemainingCopies(bookDto.getRemainingCopies());
        book.setIsEnabled(bookDto.getIsEnabled());
        book.setAuthor(bookDto.getAuthor());
        book.setEditorial(bookDto.getEditorial());

        return book;
    }
}
