package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.mapper.MapperEditorial;
import com.ap.librarymanagement.model.Editorial;
import com.ap.librarymanagement.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements IEditorial {

    private final EditorialRepository editorialRepository;

    @Override
    public List<EditorialDto> findAll() {
        return editorialRepository.findAll().stream()
                .map(MapperEditorial::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String save(EditorialDto editorialDto) {
        Editorial editorial = MapperEditorial.toEntity(editorialDto);
        editorialRepository.save(editorial);
        return "Editorial saved successfully";
    }

    @Override
    public EditorialDto find(String name) {
        Editorial editorial = editorialRepository.findByName(name);
        return MapperEditorial.toDto(editorial);
    }

    @Override
    public EditorialDto find(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();
        return MapperEditorial.toDto(editorial);
    }

    @Override
    public String update(Long id, EditorialDto editorialDto) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();

        editorial.setName(editorialDto.getName());
        editorial.setIsEnabled(editorialDto.getIsEnabled());

        editorialRepository.save(editorial);

        return "Editorial with ID: " + id + " was successfully updated";
    }

    @Override
    public String delete(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();

        editorial.setIsEnabled(false);

        editorialRepository.save(editorial);

        return "Editorial with ID: " + id + " was successfully removed";
    }

    @Override
    public String restore(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();

        editorial.setIsEnabled(true);

        editorialRepository.save(editorial);

        return "Editorial with ID: " + id + " was successfully restored";
    }
}
