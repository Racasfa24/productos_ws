package com.ecommerce.back.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.repositories.CategoriasRepository;

@Service
public class CategoriasService {

    //--Creamos e inyectamos el repositorio de Categorias para poder utilizarlo en los métodos del servicio.--
    CategoriasRepository categoriasRepository;
    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<CategoriasEntity> obtenerCategorias() {
        return categoriasRepository.findAll();
    }


}
