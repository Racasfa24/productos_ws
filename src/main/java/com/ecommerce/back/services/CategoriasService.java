package com.ecommerce.back.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.back.DTOS.CategoriasDTO;
import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.mappers.CategoriaMapper;
import com.ecommerce.back.repositories.CategoriasRepository;

@Service
public class CategoriasService {

    //--Creamos e inyectamos el repositorio de Categorias para poder utilizarlo en los métodos del servicio.--
    private final CategoriasRepository categoriasRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriasService(CategoriasRepository categoriasRepository, CategoriaMapper categoriaMapper) {
        this.categoriasRepository = categoriasRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriasEntity> obtenerCategorias() {
        return categoriasRepository.findAll();
    }

    public void guardarCategoria(CategoriasDTO categoria) {
        
        CategoriasEntity categoriaEn = categoriaMapper.toEntity(categoria);
        categoriasRepository.save(categoriaEn);
    }


}
