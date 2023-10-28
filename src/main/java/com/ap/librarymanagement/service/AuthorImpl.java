package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorImpl implements IAuthor {

    private final AuthorRepository authorRepository;
    @Override
    public List<AuthorDto> findAll() {
        return null;
    }

    @Override
    public String save(AuthorDto authorDto) {
        return null;
    }

    @Override
    public AuthorDto find(String surname) {
        return null;
    }

    @Override
    public AuthorDto find(Long id) {
        return null;
    }

    @Override
    public String update(Long id, AuthorDto authorDto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
