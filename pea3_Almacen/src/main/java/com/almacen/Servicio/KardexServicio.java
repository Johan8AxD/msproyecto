package com.almacen.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.Kardex;
import com.almacen.Interfaces.KardexInterfaces;
import com.almacen.Repositorio.KardexRepositorio;

@Service
public class KardexServicio implements KardexInterfaces{
	@Autowired 
	private KardexRepositorio krepos;

	@Override
	public List<Kardex> lstKar() {
		List<Kardex> kar = krepos.findAll(); 
		return kar;
	}

	@Override
	public Kardex Guardar(Kardex kar) {
		Kardex kard = krepos.save(kar);
		return kard;
	}

	@Override
	public void EliminarKardex(int id) {
		krepos.deleteById(id);
	}

	@Override
	public Optional<Kardex> GetIDKardex(int id) {
		Optional<Kardex> getid = krepos.findById(id);
		return getid;
	}

	
}
