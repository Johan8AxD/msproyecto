package com.almacen.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almacen.Entidad.Kardex;

@Repository
public interface KardexRepositorio extends JpaRepository<Kardex, Integer>{

}
