package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements IEditorial {

    private final EditorialRepository editorialRepository;

    @Override
    public List<EditorialDto> findAll() {
        return null;
    }

    @Override
    public String save(EditorialDto editorialDto) {
        return null;
    }

    @Override
    public EditorialDto find(String surname) {
        return null;
    }

    @Override
    public EditorialDto find(Long id) {
        return null;
    }

    @Override
    public String update(Long id, EditorialDto editorialDto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
