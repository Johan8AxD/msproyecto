package com.almacen.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almacen.Entidad.Inventario;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Integer>{

}
