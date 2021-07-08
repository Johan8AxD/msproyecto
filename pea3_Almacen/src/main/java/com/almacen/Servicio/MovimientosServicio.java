package com.almacen.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.Almacen;
import com.almacen.Entidad.Empleado;
import com.almacen.Entidad.Inventario;
import com.almacen.Entidad.Kardex;
import com.almacen.Entidad.Movimientos;
import com.almacen.Entidad.PedidoInterno;
import com.almacen.Interfaces.MovimientosInterfaces;
import com.almacen.Repositorio.MovimientosRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientosServicio implements MovimientosInterfaces{

	@Autowired
	private MovimientosRepositorio mrepos;
	
	@Override
	public List<Movimientos> lstMov() {
		List<Movimientos> mov = mrepos.findAll(); 
		return mov;
	}
	
	@Override
	public Movimientos Guardar(Movimientos mov) {
		Movimientos movi = mrepos.save(mov);
		return movi;
	}

	@Override
	public void EliminarMovimientos(int id) {
		mrepos.deleteById(id);
	}

	@Override
	public Optional<Movimientos> GetIDMovimiento(int id) {
		Optional<Movimientos> getid = mrepos.findById(id);
		return getid;
	}

	@Override
	public List<Movimientos> listarxAlmacen(Almacen almacen) {
		return mrepos.findByAlmacen(almacen);
	}

	@Override
	public List<Movimientos> listarxKardex(Kardex kardex) {
		return mrepos.findByKardex(kardex);
	}

	@Override
	public List<Movimientos> listarxPInterno(PedidoInterno pedii) {
		return mrepos.findByPedidointerno(pedii);
	}

	@Override
	public List<Movimientos> listarxInventario(Inventario inve) {
		return mrepos.findByInventario(inve);
	}

	@Override
	public List<Movimientos> listarxEmpleados(Empleado emple) {
		return mrepos.findByEmpleado(emple);
	}

}
