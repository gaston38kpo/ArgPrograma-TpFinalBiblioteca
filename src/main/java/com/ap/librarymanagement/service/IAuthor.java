package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.AuthorDto;

import java.util.List;

public interface IAuthor {

    List<AuthorDto> findAll();

    String save(AuthorDto authorDto);

    AuthorDto find(String name);

    AuthorDto find(Long id);

    String update(Long id, AuthorDto authorDto);

    String delete(Long id);

    String restore(Long id);
}
