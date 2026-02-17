package com.ecommerce.back.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias_postres", schema = "productos")
public class CategoriasProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categorias_postres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postre",nullable = false)
    private PostresEntity postre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria",nullable = false)
    private CategoriasEntity categoria;

    public Long getId_categorias_postres() {
        return id_categorias_postres;
    }

    public void setId_categorias_postres(Long id_categorias_postres) {
        this.id_categorias_postres = id_categorias_postres;
    }

    public PostresEntity getPostre() {
        return postre;
    }

    public void setPostre(PostresEntity postre) {
        this.postre = postre;
    }

    public CategoriasEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEntity categoria) {
        this.categoria = categoria;
    }

    


}
