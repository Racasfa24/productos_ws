package com.ecommerce.back.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "postres", schema = "productos")
@Getter @Setter
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

}
