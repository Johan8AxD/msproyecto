package com.almacen.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.Empleado;
import com.almacen.Interfaces.EmpleadoInterfaces;
import com.almacen.Repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicio implements EmpleadoInterfaces{

	@Autowired
	private EmpleadoRepositorio erepos;
	
	@Override
	public List<Empleado> lstEmpl() {
		List<Empleado> emp = erepos.findAll();
		return emp;
	}

}
