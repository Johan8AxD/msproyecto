package com.almacen.Interfaces;

import java.util.List;
import java.util.Optional;

import com.almacen.Entidad.Kardex;

public interface KardexInterfaces {
	//Listar
	public List<Kardex> lstKar();
		
	//Guardar
	public Kardex Guardar(Kardex kar);
			
	//Eliminar
	public void EliminarKardex(int id);
		
	//GET BY ID 
	public Optional<Kardex> GetIDKardex(int id);
}
