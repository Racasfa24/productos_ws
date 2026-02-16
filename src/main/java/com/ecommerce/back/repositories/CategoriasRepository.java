package com.ecommerce.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.entities.CategoriasEntity;

//--Solo se genera la interface, en caso de necesitar una consulta sumamente customizada, será necesario crear una clase que implemente esta interface y escribir la consulta personalizada ahí, 
//--pero para consultas básicas como findAll, findById, save, deleteById, etc., no es necesario escribir ningún código adicional, 
//-- ya que JpaRepository proporciona estas funcionalidades de forma predeterminada.--
public interface CategoriasRepository  extends JpaRepository<CategoriasEntity, Long> {}
