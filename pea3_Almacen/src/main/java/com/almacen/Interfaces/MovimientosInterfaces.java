package com.almacen.Interfaces;

import java.util.List;
import java.util.Optional;

import com.almacen.Entidad.Almacen;
import com.almacen.Entidad.Empleado;
import com.almacen.Entidad.Inventario;
import com.almacen.Entidad.Kardex;
import com.almacen.Entidad.Movimientos;
import com.almacen.Entidad.PedidoInterno;

public interface MovimientosInterfaces {
	//Listar
	public List<Movimientos> lstMov();
	
	//Listar Almacen
	public List<Movimientos> listarxAlmacen(Almacen almacen);
	
	//Listar kardex
	public List<Movimientos> listarxKardex(Kardex kardex);
	
	//Listar pedido interno
	public List<Movimientos> listarxPInterno(PedidoInterno pedii);
	
	//Listar Almacen
	public List<Movimientos> listarxInventario(Inventario inve);	
	
	//Listar Almacen
	public List<Movimientos> listarxEmpleados(Empleado emple);	
	
	//Guardar
	public Movimientos Guardar(Movimientos mov);
				
	//Eliminar
	public void EliminarMovimientos(int id);
			
	//GET BY ID 
	public Optional<Movimientos> GetIDMovimiento(int id);
}
