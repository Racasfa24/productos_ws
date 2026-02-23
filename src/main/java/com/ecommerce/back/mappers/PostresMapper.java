package com.ecommerce.back.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.back.DTOS.CategoriasDTO;
import com.ecommerce.back.DTOS.PostresDTOCreate;
import com.ecommerce.back.DTOS.PostresDTOListar;
import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.entities.CategoriasProductosEntity;
import com.ecommerce.back.entities.PostresEntity;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface PostresMapper {

    //--Se indica que el campo "categorias" del DTO se mapea a partir de la expresión "mapCategorias(entity.getCategorias())", 
    //-- que es un método personalizado definido en el mismo mapper. Este método toma el conjunto de relaciones entre postres y categorías (Set<CategoriasProductosEntity>) y 
    //-- lo convierte en un conjunto de DTOs de categorías (Set<CategoriasDTO>), esto debido a que en este caso, PostresDTOListar espera un set de CategoriasDTO.
    @Mapping(target = "categorias", expression = "java(mapCategorias(entity.getCategorias()))")
    PostresDTOListar toResponseDto(PostresEntity entity);

    default Set<CategoriasDTO> mapCategorias(Set<CategoriasProductosEntity> relaciones) {

        //--Validacion de nullpointer
        if (relaciones == null) {
            return new HashSet<>();
        }

        //--Retorna las relaciones para el mappeo.
        return relaciones.stream()
        //-- Por cada relación, se obtiene la categoría asociada a esa relación y se crea un nuevo DTO de categoría con los datos correspondientes.  
                .map(rel -> {
                    CategoriasEntity categoria = rel.getCategoria();

                    CategoriasDTO dto = new CategoriasDTO();
                    dto.setId_categoria(categoria.getId_categoria());
                    dto.setNombre(categoria.getNombre());

                    return dto;
                })
                .collect(Collectors.toSet());
    }

    //--Se realiza el mapeo clasico para crear al postre, pero se ignoran los campos "id_postre" y "categorias" ya que el id se genera automáticamente y las categorías se manejan por separado.
    @Mapping(target = "id_postre", ignore = true)
    @Mapping(target = "categorias", ignore = true)
    PostresEntity toEntity(PostresDTOCreate dto);
}
