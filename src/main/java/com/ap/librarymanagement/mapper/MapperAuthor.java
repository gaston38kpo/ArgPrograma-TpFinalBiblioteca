package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.model.Author;

public class MapperAuthor {

    public static AuthorDto toDto(Author author) {
        AuthorDto AuthorDto = new AuthorDto();

        AuthorDto.setName(author.getName());
        AuthorDto.setIsEnabled(author.getIsEnabled());

        return AuthorDto;
    }

    public static Author toEntity(AuthorDto authorDto) {
        Author Author = new Author();

        Author.setName(authorDto.getName());
        Author.setIsEnabled(authorDto.getIsEnabled());

        return Author;
    }
}
