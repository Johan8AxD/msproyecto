package com.almacen.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.Entidad.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{

}
