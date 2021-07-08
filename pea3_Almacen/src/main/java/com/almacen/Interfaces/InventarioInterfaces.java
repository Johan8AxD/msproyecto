package com.almacen.Interfaces;

import java.util.List;
import java.util.Optional;

import com.almacen.Entidad.Inventario;

public interface InventarioInterfaces {
	//Listar
	public List<Inventario> lstInv();
		
	//Guardar
	public Inventario Guardar(Inventario inv);
			
	//Eliminar
	public void EliminarInvetario(int id);
		
	//GET BY ID 
	public Optional<Inventario> GetIDInventario(int id);
		
}
