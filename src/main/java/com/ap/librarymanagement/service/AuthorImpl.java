package com.ap.librarymanagement.service;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.mapper.MapperAuthor;
import com.ap.librarymanagement.model.Author;
import com.ap.librarymanagement.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorImpl implements IAuthor {

    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream()
                .map(MapperAuthor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String save(AuthorDto authorDto) {
        Author author = MapperAuthor.toEntity(authorDto);
        authorRepository.save(author);
        return "Author saved successfully";
    }

    @Override
    public AuthorDto find(String name) {
        Author author = authorRepository.findByName(name);
        return MapperAuthor.toDto(author);
    }

    @Override
    public AuthorDto find(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return MapperAuthor.toDto(author);
    }

    @Override
    public String update(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElseThrow();

        author.setName(authorDto.getName());
        author.setIsEnabled(authorDto.getIsEnabled());

        authorRepository.save(author);

        return "Author with ID: " + id + " was successfully updated";
    }

    @Override
    public String delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();

        author.setIsEnabled(false);

        authorRepository.save(author);

        return "Author with ID: " + id + " was successfully removed";
    }

    @Override
    public String restore(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();

        author.setIsEnabled(true);

        authorRepository.save(author);

        return "Author with ID: " + id + " was successfully restored";
    }
}
