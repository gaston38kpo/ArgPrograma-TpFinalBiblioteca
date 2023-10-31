package com.ap.librarymanagement.controller;

import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.model.Author;
import com.ap.librarymanagement.model.Editorial;
import com.ap.librarymanagement.service.BookImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookImpl bookService;

    @Test
    public void testGetAllBooks() {
        List<BookDto> bookList = new ArrayList<>();
        bookList.add(new BookDto());
        Mockito.when(bookService.findAll()).thenReturn(bookList);

        ResponseEntity<List<BookDto>> response = bookController.getAllBooks();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(bookList, response.getBody());
    }

    @Test
    public void testFindBookById() {
        BookDto book = new BookDto();
        book.setId(1L);
        Mockito.when(bookService.find(1L)).thenReturn(book);

        ResponseEntity<BookDto> response = bookController.findBookById(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(book, response.getBody());
    }

    @Test
    public void testFindBookByName() {
        BookDto book = new BookDto();
        book.setTitle("The Great Adventure");
        Mockito.when(bookService.find("The Great Adventure")).thenReturn(book);

        ResponseEntity<BookDto> response = bookController.findBookByName(book);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(book, response.getBody());
    }

    @Test
    public void testSaveBook() {
        BookDto book = new BookDto();
        book.setIsbn(444L);
        book.setTitle("new");
        book.setYear(2010);
        book.setCopies(12);
        book.setBorrowedCopies(3);
        book.setRemainingCopies(7);
        book.setIsEnabled(true);

        Set<Author> authorList = new HashSet<>();
        authorList.add(new Author(3L, "David Brown", true));
        book.setAuthorList(authorList);

        book.setEditorial(new Editorial(2L, "Mystery Publications", true));

        Mockito.when(bookService.save(book)).thenReturn("success");

        ResponseEntity<String> response = bookController.saveBook(book);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals("success", response.getBody());
    }

    @Test
    public void testUpdateBook() {
        BookDto book = new BookDto();
        book.setTitle("edited");
        book.setIsbn(1234L);
        book.setYear(2001);
        book.setCopies(212);
        book.setBorrowedCopies(62);
        book.setRemainingCopies(125);
        book.setIsEnabled(true);

        Set<Author> authorList = new HashSet<>();
        authorList.add(new Author(3L, "David Brown", true));
        authorList.add(new Author(3L, "Emily Davis",true));
        book.setAuthorList(authorList);

        book.setEditorial(new Editorial(2L, "Mystery Publications", true));

        Mockito.when(bookService.find(1L)).thenReturn(book);

        ResponseEntity<String> response = bookController.updateBook(1L, book);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Book 'edited' was updated successfully", response.getBody());
    }

    @Test
    public void testDeleteBook() {
        Mockito.when(bookService.find(1L)).thenReturn(new BookDto());

        ResponseEntity<String> response = bookController.deleteBook(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Book with ID: 1 was successfully removed", response.getBody());
    }

    @Test
    public void testRestoreBook() {
        Mockito.when(bookService.find(1L)).thenReturn(new BookDto());

        ResponseEntity<String> response = bookController.restoreBook(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Book with ID: 1 was successfully restored", response.getBody());
    }
}