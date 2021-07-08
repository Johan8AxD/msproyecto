package com.almacen.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almacen.Entidad.Almacen;
import com.almacen.Entidad.Empleado;
import com.almacen.Entidad.Inventario;
import com.almacen.Entidad.Kardex;
import com.almacen.Entidad.Movimientos;
import com.almacen.Entidad.PedidoInterno;

@Repository
public interface MovimientosRepositorio extends JpaRepository<Movimientos, Integer>{
	
	List<Movimientos> findByAlmacen(Almacen almacen);
	List<Movimientos> findByKardex(Kardex kardex);
	List<Movimientos> findByPedidointerno(PedidoInterno pedidointerno);
	List<Movimientos> findByInventario(Inventario inventario);
	List<Movimientos> findByEmpleado(Empleado empleado);
}
