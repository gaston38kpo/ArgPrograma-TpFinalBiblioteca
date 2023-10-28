package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.EditorialDto;

import java.util.List;

public interface IEditorial {

    List<EditorialDto> findAll();

    String save(EditorialDto editorialDto);

    EditorialDto find(String surname);

    EditorialDto find(Long id);

    String update(Long id, EditorialDto editorialDto);

    String delete(Long id);
}
