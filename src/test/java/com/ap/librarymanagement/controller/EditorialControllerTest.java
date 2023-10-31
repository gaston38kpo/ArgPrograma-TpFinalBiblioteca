package com.ap.librarymanagement.controller;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.service.EditorialImpl;
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
public class EditorialControllerTest {
    @InjectMocks
    private EditorialController editorialController;

    @Mock
    private EditorialImpl editorialService;

    @Test
    public void testGetAllEditorials() {
        List<EditorialDto> editorialList = new ArrayList<>();
        editorialList.add(new EditorialDto());
        Mockito.when(editorialService.findAll()).thenReturn(editorialList);

        ResponseEntity<List<EditorialDto>> response = editorialController.getAllEditorials();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(editorialList, response.getBody());
    }

    @Test
    public void testFindEditorialById() {
        EditorialDto editorial = new EditorialDto();
        editorial.setId(1L);
        Mockito.when(editorialService.find(1L)).thenReturn(editorial);

        ResponseEntity<EditorialDto> response = editorialController.findEditorialById(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(editorial, response.getBody());
    }

    @Test
    public void testFindEditorialByName() {
        EditorialDto editorial = new EditorialDto();
        editorial.setName("John Smith");
        Mockito.when(editorialService.find("John Smith")).thenReturn(editorial);

        EditorialDto request = new EditorialDto();
        request.setName("John Smith");

        ResponseEntity<EditorialDto> response = editorialController.findEditorialByName(request);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(editorial, response.getBody());
    }

    @Test
    public void testSaveEditorial() {
        EditorialDto editorial = new EditorialDto();
        editorial.setName("Autor de prueba 1");
        Mockito.when(editorialService.save(editorial)).thenReturn("success");

        ResponseEntity<String> response = editorialController.saveEditorial(editorial);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals("success", response.getBody());
    }

    @Test
    public void testUpdateEditorial() {
        EditorialDto editorial = new EditorialDto(1L, "John Smith", true);
        Mockito.when(editorialService.find(1L)).thenReturn(editorial);

        EditorialDto request = new EditorialDto(1L, "John", true);
        ResponseEntity<String> response = editorialController.updateEditorial(1L, request);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Editorial 'John' was updated successfully", response.getBody());
    }

    @Test
    public void testDeleteEditorial() {
        Mockito.when(editorialService.find(1L)).thenReturn(new EditorialDto());

        ResponseEntity<String> response = editorialController.deleteEditorial(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Editorial with ID: 1 was successfully removed", response.getBody());
    }

    @Test
    public void testRestoreEditorial() {
        Mockito.when(editorialService.find(1L)).thenReturn(new EditorialDto());

        ResponseEntity<String> response = editorialController.restoreEditorial(1L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Editorial with ID: 1 was successfully restored", response.getBody());
    }
}