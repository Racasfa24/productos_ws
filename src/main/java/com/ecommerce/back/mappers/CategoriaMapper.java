package com.ecommerce.back.mappers;

import org.mapstruct.Mapper;

import com.ecommerce.back.DTOS.CategoriasDTO;
import com.ecommerce.back.entities.CategoriasEntity;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriasEntity toEntity(CategoriasDTO dto);
    CategoriasDTO toDto(CategoriasEntity entity);
}
