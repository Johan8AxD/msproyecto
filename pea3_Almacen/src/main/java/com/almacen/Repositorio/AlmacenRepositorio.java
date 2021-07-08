package com.almacen.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almacen.Entidad.Almacen;

@Repository
public interface AlmacenRepositorio extends JpaRepository<Almacen, Integer>{
	
}
