package com.ecommerce.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.back.DTOS.CategoriasDTO;
import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.mappers.CategoriaMapper;
import com.ecommerce.back.repositories.CategoriasRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriasService {

    //--Creamos e inyectamos el repositorio de Categorias para poder utilizarlo en los métodos del servicio.--
    private final CategoriasRepository categoriasRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriasService(CategoriasRepository categoriasRepository, CategoriaMapper categoriaMapper) {
        this.categoriasRepository = categoriasRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriasDTO> obtenerCategorias() {

        List<CategoriasEntity> categoriasEn = categoriasRepository.findAll();
        List<CategoriasDTO> categoriasDTO = new ArrayList<>();
        for(CategoriasEntity categoriaEn : categoriasEn){
            categoriasDTO.add(categoriaMapper.toDto(categoriaEn));

        }
        return categoriasDTO;
    }

    public void guardarCategoria(CategoriasDTO categoria) {
        
        CategoriasEntity categoriaEn = categoriaMapper.toEntity(categoria);
        categoriasRepository.save(categoriaEn);
    }

    @Transactional
    public void editarNombreCategoria(CategoriasDTO categoria){

        CategoriasEntity categoriaEn = categoriasRepository.findById(categoria.getId_categoria()).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoriaEn.setNombre(categoria.getNombre());
    }

    public CategoriasDTO encontrarCategoria(Long id_categoria) {

        CategoriasEntity categoriaEn = categoriasRepository.findById(id_categoria).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return categoriaMapper.toDto(categoriaEn);
    }


}
