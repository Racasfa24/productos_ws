package com.ecommerce.back.entities;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.back.services.CategoriasService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    //-- Al igual que en el repositorio, se inyecta el servicio de Categorias para poder utilizarlo en los métodos del controlador.--
    CategoriasService categoriasService;
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/listar_categorias")
    public ResponseEntity<List<CategoriasEntity>> getMethodName() {

        return ResponseEntity.ok(categoriasService.obtenerCategorias());
    }
    

}
