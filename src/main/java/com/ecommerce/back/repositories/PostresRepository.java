package com.ecommerce.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.entities.CategoriasEntity;

public interface PostresRepository extends JpaRepository<CategoriasEntity, Long> {

}
