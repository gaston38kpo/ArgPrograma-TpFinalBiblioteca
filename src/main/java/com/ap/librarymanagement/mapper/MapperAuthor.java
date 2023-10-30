package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.AuthorDto;
import com.ap.librarymanagement.model.Author;

public class MapperAuthor {

    public static AuthorDto toDto(Author author) {
        AuthorDto AuthorDto = new AuthorDto();

        AuthorDto.setId(author.getId());
        AuthorDto.setName(author.getName());
        AuthorDto.setIsEnabled(author.getIsEnabled());
        AuthorDto.setBookList(author.getBookList());

        return AuthorDto;
    }

    public static Author toEntity(AuthorDto authorDto) {
        Author Author = new Author();

        Author.setId(authorDto.getId());
        Author.setName(authorDto.getName());
        Author.setIsEnabled(authorDto.getIsEnabled());
        Author.setBookList(authorDto.getBookList());

        return Author;
    }
}
