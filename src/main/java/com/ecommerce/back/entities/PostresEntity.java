package com.ecommerce.back.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "postres", schema = "productos")
public class PostresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_postre;

    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private int stock;
    
    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "postre", fetch = FetchType.LAZY)
    private Set<CategoriasProductosEntity> categorias;

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

    public Set<CategoriasProductosEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriasProductosEntity> categorias) {
        this.categorias = categorias;
    }

    
}
