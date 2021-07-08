package com.almacen.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.Almacen;
import com.almacen.Interfaces.AlmacenInterfaces;
import com.almacen.Repositorio.AlmacenRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlmacenServicio implements AlmacenInterfaces{
	
	@Autowired 
	private AlmacenRepositorio almacenr;

	@Override
	public List<Almacen> lstAlmc() {
		List<Almacen> almac = almacenr.findAll(); 
		return almac;
	}

	@Override
	public Almacen Guardar(Almacen almac) {
		Almacen alm = almacenr.save(almac);
		return alm;
	}

	@Override
	public void EliminarAlmacen(int id) {
		almacenr.deleteById(id);
		
	}

	@Override
	public Optional<Almacen> GetIDAlmacen(int id) {
		Optional<Almacen> getid = almacenr.findById(id);
		return getid;
	}

}
