package com.ecommerce.back.DTOS;

import java.util.Set;

public class PostresDTOListar {
    private Long id_postre;

    private String nombre;
    
    private int stock;
    
    private float precio;

    private String descripcion;

    //--Representa la relacion con categorias.
    private Set<CategoriasDTO> categorias;

    public Long getId_postre() {
        return id_postre;
    }

    public void setId_postre(Long id_postre) {
        this.id_postre = id_postre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<CategoriasDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriasDTO> categorias) {
        this.categorias = categorias;
    }

    

}
