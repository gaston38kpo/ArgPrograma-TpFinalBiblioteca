package com.ap.librarymanagement.mapper;

import com.ap.librarymanagement.dto.EditorialDto;
import com.ap.librarymanagement.model.Editorial;
import org.modelmapper.ModelMapper;

public class MapperEditorial {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static EditorialDto toDto(Editorial editorial) {
        return modelMapper.map(editorial, EditorialDto.class);
    }

    public static Editorial toEntity(EditorialDto authorDto) {
        return modelMapper.map(authorDto, Editorial.class);
    }
}
