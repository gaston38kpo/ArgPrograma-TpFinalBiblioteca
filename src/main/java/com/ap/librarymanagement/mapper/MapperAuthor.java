package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.model.Author;
import org.modelmapper.ModelMapper;

public class MapperAuthor {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static AuthorDto toDto(Author author) {
        return modelMapper.map(author, AuthorDto.class);
    }

    public static Author toEntity(AuthorDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }
}
