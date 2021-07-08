package com.almacen.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.Inventario;
import com.almacen.Interfaces.InventarioInterfaces;
import com.almacen.Repositorio.InventarioRepositorio;

@Service
public class InventarioServicio implements InventarioInterfaces{

	@Autowired
	private InventarioRepositorio irepos;
	
	@Override
	public List<Inventario> lstInv() {
		List<Inventario> inv = irepos.findAll();
		return inv;
	}

	@Override
	public Inventario Guardar(Inventario inv) {
		Inventario in = irepos.save(inv);
		return in;
	}

	@Override
	public void EliminarInvetario(int id) {
		irepos.deleteById(id);	
	}

	@Override
	public Optional<Inventario> GetIDInventario(int id) {
		Optional<Inventario> getid = irepos.findById(id);
		return getid;
	}

}
