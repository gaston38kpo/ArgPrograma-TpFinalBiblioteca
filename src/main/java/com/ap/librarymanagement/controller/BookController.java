package com.ap.librarymanagement.controller;


import com.ap.librarymanagement.dto.BookDto;
import com.ap.librarymanagement.service.BookImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookImpl bookService;

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }
    /* GET http://localhost:8080/books/ */

    @GetMapping("/find")
    public ResponseEntity<BookDto> findBookById(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.find(id), HttpStatus.OK);
    }
    /* GET http://localhost:8080/books/find?id=1 */

    @PostMapping("/findByTitle")
    public ResponseEntity<BookDto> findBookByName(@RequestBody BookDto bookDto) {
        if (bookDto == null || bookDto.getTitle() == null || bookDto.getTitle().isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        BookDto bookDtoFound = bookService.find(bookDto.getTitle());

        if (bookDtoFound == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(bookDtoFound, HttpStatus.OK);
    }
    /* POST http://localhost:8080/books/findByTitle
{
    "title": "The Great Adventure"
}
    */

    @PostMapping("/save")
    public ResponseEntity<String> saveBook(@RequestBody BookDto bookDto) {
        String res = bookService.save(bookDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    /* POST http://localhost:8080/books/save
{
    "isbn": 444,
    "title": "new",
    "year": 2010,
    "copies": 12,
    "borrowedCopies": 3,
    "remainingCopies": 7,
    "isEnabled": true,
    "authorList": [
        {
            "id": 3,
            "name": "David Brown",
            "isEnabled": true
        }
    ],
    "editorial": {
        "id": 2,
        "name": "Mystery Publications",
        "isEnabled": true
    }
}
    */

    @PutMapping("/update")
    public ResponseEntity<String> updateBook(@RequestParam Long id, @RequestBody BookDto bookDto) {
        BookDto book = bookService.find(id);

        if (book == null) {
            String res = "Book with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setYear(bookDto.getYear());
        book.setCopies(bookDto.getCopies());
        book.setBorrowedCopies(bookDto.getBorrowedCopies());
        book.setRemainingCopies(bookDto.getRemainingCopies());
        book.setIsEnabled(bookDto.getIsEnabled());
        book.setAuthorList(bookDto.getAuthorList());
        book.setEditorial(bookDto.getEditorial());

        bookService.update(id, book);

        String res = "Book '" + book.getTitle() + "' was updated successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* PUT http://localhost:8080/books/update?id=1
{
    "isbn": 1234,
    "title": "edited4",
    "year": 2001,
    "copies": 212,
    "borrowedCopies": 62,
    "remainingCopies": 125,
    "authorList": [
        {
            "id": 3,
            "name": "David Brown",
            "isEnabled": true
        },
        {
            "id": 4,
            "name": "Emily Davis",
            "isEnabled": true,
            "bookList": []
        }
    ],
    "editorial": {
        "id": 2,
        "name": "Mystery Publications",
        "isEnabled": true
    }
}
    */

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestParam Long id) {
        if (bookService.find(id) == null) {
            return new ResponseEntity<>("Book with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(bookService.delete(id));
    }
    /* DELETE http://localhost:8080/books/delete?id=1 */

    @PatchMapping("/restore")
    public ResponseEntity<String> restoreBook(@RequestParam Long id) {
        if (bookService.find(id) == null) {
            return new ResponseEntity<>("Book with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(bookService.restore(id));
    }
    /* PUT http://localhost:8080/books/restore?id=1 */

}
