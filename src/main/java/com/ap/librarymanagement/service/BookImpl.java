package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.mapper.MapperBook;
import com.ap.librarymanagement.model.Book;
import com.ap.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookImpl implements IBook {

    @Autowired
    private final BookRepository bookRepository;

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(MapperBook::toDto)
                .toList();
    }

    @Override
    public String save(BookDto bookDto) {
        Book book = MapperBook.toEntity(bookDto);
        bookRepository.save(book);
        return "Book saved successfully";
    }

    @Override
    public BookDto find(String title) {
        Book book = bookRepository.findByTitle(title);
        return MapperBook.toDto(book);
    }

    @Override
    public BookDto find(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return MapperBook.toDto(book);
    }

    @Override
    public String update(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setCopies(bookDto.getCopies());
        book.setBorrowedCopies(bookDto.getBorrowedCopies());
        book.setRemainingCopies(bookDto.getRemainingCopies());
        book.setIsEnabled(bookDto.getIsEnabled());
        book.setAuthorList(bookDto.getAuthorList());
        book.setEditorial(bookDto.getEditorial());

        bookRepository.save(book);

        return "Book with ID: " + id + " was successfully updated";
    }

    @Override
    public String delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setIsEnabled(false);

        bookRepository.save(book);

        return "Book with ID: " + id + " was successfully removed";
    }

    @Override
    public String restore(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setIsEnabled(true);

        bookRepository.save(book);

        return "Book with ID: " + id + " was successfully restored";
    }
}
