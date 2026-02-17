package com.ecommerce.back.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.services.CategoriasService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.back.DTOS.CategoriasDTO;




@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    //-- Al igual que en el repositorio, se inyecta el servicio de Categorias para poder utilizarlo en los métodos del controlador.--
    CategoriasService categoriasService;
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/listar_categorias")
    public ResponseEntity<List<CategoriasEntity>> obtenerCategorias() {

        return ResponseEntity.ok(categoriasService.obtenerCategorias());
    }

    @PostMapping("/guardar_categoria")
    public ResponseEntity<String> guardarCategoria(@RequestBody CategoriasDTO dto) {

        categoriasService.guardarCategoria(dto);
        return ResponseEntity.ok("Categoria guardada correctamente");
    }
    
    

}
