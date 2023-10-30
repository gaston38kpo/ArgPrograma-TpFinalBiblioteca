package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.model.Editorial;

public class MapperEditorial {

    public static EditorialDto toDto(Editorial editorial) {
        EditorialDto EditorialDto = new EditorialDto();

        EditorialDto.setId(editorial.getId());
        EditorialDto.setName(editorial.getName());
        EditorialDto.setIsEnabled(editorial.getIsEnabled());
        EditorialDto.setBookList(editorial.getBookList());

        return EditorialDto;
    }

    public static Editorial toEntity(EditorialDto editorialDto) {
        Editorial Editorial = new Editorial();

        Editorial.setId(editorialDto.getId());
        Editorial.setName(editorialDto.getName());
        Editorial.setIsEnabled(editorialDto.getIsEnabled());
        Editorial.setBookList(editorialDto.getBookList());

        return Editorial;
    }
}
