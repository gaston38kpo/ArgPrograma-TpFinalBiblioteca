package com.ap.librarymanagement.controller;


import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.model.Book;
import com.ap.librarymanagement.service.AuthorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorImpl authorService;

    @GetMapping("/testBookList")
    public ResponseEntity<Integer> sizeOfBookList() {
        return ResponseEntity.ok(authorService.findAll().get(0).getBookList().size());
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAll());
    }
    /* GET http://localhost:8080/authors/ */

    @GetMapping("/find")
    public ResponseEntity<AuthorDto> findAuthorById(@RequestParam Long id) {
        return new ResponseEntity<>(authorService.find(id), HttpStatus.OK);
    }
    /* GET http://localhost:8080/authors/find?id=1 */

    @PostMapping("/findByName")
    public ResponseEntity<AuthorDto> findAuthorByName(@RequestBody AuthorDto authorDto) {
        if (authorDto == null || authorDto.getName() == null || authorDto.getName().isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        AuthorDto authorDtoFound = authorService.find(authorDto.getName());

        if (authorDtoFound == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(authorDtoFound, HttpStatus.OK);
    }
    /* POST http://localhost:8080/authors/findByName
{
    "name": "John Smith"
}
    */

    @PostMapping("/save")
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDto authorDto) {
        String res = authorService.save(authorDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    /* POST http://localhost:8080/authors/save
{
    "name": "Autor de prueba 1"
}
    */

    @PutMapping("/update")
    public ResponseEntity<String> updateAuthor(@RequestParam Long id, @RequestBody AuthorDto authorDto) {
        AuthorDto author = authorService.find(id);

        if (author == null) {
            String res = "Author with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        author.setName(authorDto.getName());

        authorService.update(id, author);

        String res = "Author '" + author.getName() + "' was updated successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* PUT http://localhost:8080/authors/update?id=1
{
    "name": "John"
}
    */

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam Long id) {
        AuthorDto author = authorService.find(id);

        if (author == null) {
            String res = "Author with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        author.setIsEnabled(false);

        authorService.update(id, author);

        String res = "Author '" + author.getName() + "' was deleted successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* DELETE http://localhost:8080/authors/delete?id=1 */

    @PatchMapping("/restore")
    public ResponseEntity<String> restoreAuthor(@RequestParam Long id) {
        AuthorDto author = authorService.find(id);

        if (author == null) {
            String res = "Author with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        author.setIsEnabled(true);

        authorService.update(id, author);

        String res = "Author '" + author.getName() + "' was restored successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* PUT http://localhost:8080/authors/restore?id=1 */

}
