package com.almacen.Interfaces;

import java.util.List;
import java.util.Optional;

import com.almacen.Entidad.Almacen;

public interface AlmacenInterfaces {

	//Listar
	public List<Almacen> lstAlmc();
	
	//Guardar
	public Almacen Guardar(Almacen almac);
		
	//Eliminar
	public void EliminarAlmacen(int id);
	
	//GET BY ID 
	public Optional<Almacen> GetIDAlmacen(int id);
	
	
}
