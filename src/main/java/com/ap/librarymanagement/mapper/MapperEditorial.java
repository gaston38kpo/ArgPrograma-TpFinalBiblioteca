package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.model.Editorial;

public class MapperEditorial {

    public static EditorialDto toDto(Editorial editorial) {
        EditorialDto EditorialDto = new EditorialDto();

        EditorialDto.setName(editorial.getName());
        EditorialDto.setIsEnabled(editorial.getIsEnabled());

        return EditorialDto;
    }

    public static Editorial toEntity(EditorialDto editorialDto) {
        Editorial Editorial = new Editorial();

        Editorial.setName(editorialDto.getName());
        Editorial.setIsEnabled(editorialDto.getIsEnabled());

        return Editorial;
    }
}
