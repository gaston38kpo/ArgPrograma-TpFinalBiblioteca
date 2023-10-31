package com.ap.librarymanagement.controller;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.service.AuthorImpl;
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
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorImpl authorService;

    @Test
    public void testGetAllAuthors() {
        List<AuthorDto> authorList = new ArrayList<>();
        authorList.add(new AuthorDto());
        Mockito.when(authorService.findAll()).thenReturn(authorList);

        ResponseEntity<List<AuthorDto>> response = authorController.getAllAuthors();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(authorList, response.getBody());
    }

    @Test
    public void testFindAuthorById() {
        AuthorDto author = new AuthorDto();
        author.setId(1L);
        Mockito.when(authorService.find(1L)).thenReturn(author);

        ResponseEntity<AuthorDto> response = authorController.findAuthorById(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(author, response.getBody());
    }

    @Test
    public void testFindAuthorByName() {
        AuthorDto author = new AuthorDto();
        author.setName("John Smith");
        Mockito.when(authorService.find("John Smith")).thenReturn(author);

        AuthorDto request = new AuthorDto();
        request.setName("John Smith");

        ResponseEntity<AuthorDto> response = authorController.findAuthorByName(request);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(author, response.getBody());
    }

    @Test
    public void testSaveAuthor() {
        AuthorDto author = new AuthorDto();
        author.setName("Autor de prueba 1");
        Mockito.when(authorService.save(author)).thenReturn("success");

        ResponseEntity<String> response = authorController.saveAuthor(author);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals("success", response.getBody());
    }

    @Test
    public void testUpdateAuthor() {
        AuthorDto author = new AuthorDto(1L, "John Smith", true);
        Mockito.when(authorService.find(1L)).thenReturn(author);

        AuthorDto request = new AuthorDto(1L, "John", true);
        ResponseEntity<String> response = authorController.updateAuthor(1L, request);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Author 'John' was updated successfully", response.getBody());
    }

    @Test
    public void testDeleteAuthor() {
        Mockito.when(authorService.find(1L)).thenReturn(new AuthorDto());

        ResponseEntity<String> response = authorController.deleteAuthor(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Author with ID: 1 was successfully removed", response.getBody());
    }

    @Test
    public void testRestoreAuthor() {
        Mockito.when(authorService.find(1L)).thenReturn(new AuthorDto());

        ResponseEntity<String> response = authorController.restoreAuthor(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Author with ID: 1 was successfully restored", response.getBody());
    }
}
