package com.ap.librarymanagement.controller;


import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.service.EditorialImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editorials")
public class EditorialController {

    private final EditorialImpl editorialService;

    @GetMapping("/testBookList")
    public ResponseEntity<Integer> sizeOfBookList() {
        return ResponseEntity.ok(editorialService.findAll().get(0).getBookList().size());
    }

    @GetMapping("/")
    public ResponseEntity<List<EditorialDto>> getAllEditorials() {
        return ResponseEntity.ok(editorialService.findAll());
    }
    /* GET http://localhost:8080/editorials/ */

    @GetMapping("/find")
    public ResponseEntity<EditorialDto> findEditorialById(@RequestParam Long id) {
        return new ResponseEntity<>(editorialService.find(id), HttpStatus.OK);
    }
    /* GET http://localhost:8080/editorials/find?id=1 */

    @PostMapping("/findByName")
    public ResponseEntity<EditorialDto> findEditorialByName(@RequestBody EditorialDto editorialDto) {
        if (editorialDto == null || editorialDto.getName() == null || editorialDto.getName().isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        EditorialDto editorialDtoFound = editorialService.find(editorialDto.getName());

        if (editorialDtoFound == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(editorialDtoFound, HttpStatus.OK);
    }
    /* POST http://localhost:8080/editorials/findByName
{
    "name": "Book World"
}
    */

    @PostMapping("/save")
    public ResponseEntity<String> saveEditorial(@RequestBody EditorialDto editorialDto) {
        String res = editorialService.save(editorialDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    /* POST http://localhost:8080/editorials/save
{
    "name": "Editorial de prueba 1"
}
    */

    @PutMapping("/update")
    public ResponseEntity<String> updateEditorial(@RequestParam Long id, @RequestBody EditorialDto editorialDto) {
        EditorialDto editorial = editorialService.find(id);

        if (editorial == null) {
            String res = "Editorial with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        editorial.setName(editorialDto.getName());

        editorialService.update(id, editorial);

        String res = "Editorial '" + editorial.getName() + "' was updated successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* PUT http://localhost:8080/editorials/update?id=1
{
    "name": "John"
}
    */

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEditorial(@RequestParam Long id) {
        EditorialDto editorial = editorialService.find(id);

        if (editorial == null) {
            String res = "Editorial with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        editorial.setIsEnabled(false);

        editorialService.update(id, editorial);

        String res = "Editorial '" + editorial.getName() + "' was deleted successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* DELETE http://localhost:8080/editorials/delete?id=1 */

    @PatchMapping("/restore")
    public ResponseEntity<String> restoreEditorial(@RequestParam Long id) {
        EditorialDto editorial = editorialService.find(id);

        if (editorial == null) {
            String res = "Editorial with ID " + id + " not found";
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        editorial.setIsEnabled(true);

        editorialService.update(id, editorial);

        String res = "Editorial '" + editorial.getName() + "' was restored successfully";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /* PUT http://localhost:8080/editorials/restore?id=1 */

}
