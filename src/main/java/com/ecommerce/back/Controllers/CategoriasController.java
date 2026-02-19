package com.ecommerce.back.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.back.DTOS.CategoriasDTO;
import com.ecommerce.back.entities.CategoriasEntity;
import com.ecommerce.back.services.CategoriasService;

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
    
    @PostMapping("/editar_categoria")
    public ResponseEntity<String> editarNombreCategoria(@RequestBody CategoriasDTO dto) {

        categoriasService.editarNombreCategoria(dto);
        return ResponseEntity.ok("Nombre de categoria editado correctamente");
    }

    @GetMapping("/encontrar_categoria/{id_categoria}")
    public ResponseEntity<CategoriasDTO> encontrarCategoria(@PathVariable Long id_categoria){

        CategoriasDTO categoria = categoriasService.encontrarCategoria(id_categoria);
        return ResponseEntity.ok(categoria);
    }
    

}
