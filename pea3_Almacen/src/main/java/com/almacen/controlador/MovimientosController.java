package com.almacen.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.almacen.Entidad.Almacen;
import com.almacen.Entidad.Empleado;
import com.almacen.Entidad.Inventario;
import com.almacen.Entidad.Kardex;
import com.almacen.Entidad.Movimientos;
import com.almacen.Entidad.PedidoInterno;
import com.almacen.Interfaces.MovimientosInterfaces;

@Controller
@RequestMapping(name="/")
public class MovimientosController {
	
	@Autowired
	private MovimientosInterfaces minter;
	
	/**********************************************/
	/*LISTAR*/
	/**********************************************/
	
	@RequestMapping(value = "/listarmovimientos", method = RequestMethod.GET)
	public ResponseEntity<List<Movimientos>> MovimientosLst(@RequestParam(name = "id_almacen", required = false) Integer id_almacen,
			@RequestParam(name = "id_kardex", required = false) Integer id_kardex,
			@RequestParam(name = "id_pedidointerno", required = false) Integer id_pedidointerno,
			@RequestParam(name = "id_inventario", required = false) Integer id_inventario,
			@RequestParam(name = "id_empleado", required = false) Integer id_empleado
			){ 
		
		List<Movimientos> movi = new ArrayList<>(); 
		
		
		/*ALMACEN*/
		if(id_almacen == null) {
			movi = minter.lstMov();
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			movi = minter.listarxAlmacen(Almacen.builder().id_almacen(id_almacen).build());
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		/*KARDEX*/
		if(id_kardex == null) {
			movi = minter.lstMov();
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			movi = minter.listarxKardex(Kardex.builder().id_Kardex(id_kardex).build());
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		/*PEDIDO*/
		if(id_pedidointerno == null) {
			movi = minter.lstMov();
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			movi = minter.listarxPInterno(PedidoInterno.builder().id_pedidointerno(id_pedidointerno).build());
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		/*INVENTARIO*/
		if(id_inventario == null) {
			movi = minter.lstMov();
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			movi = minter.listarxInventario(Inventario.builder().id_inventario(id_inventario).build());
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		/*EMPLEADO*/
		if(id_empleado == null) {
			movi = minter.lstMov();
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			movi = minter.listarxEmpleados(Empleado.builder().id_empleado(id_empleado).build());
			if(movi.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.ok(movi);
	}
	
	/**********************************************/
	/*GUARDAR*/
	/**********************************************/
	@RequestMapping(value = "guardarMovimientos", method = RequestMethod.POST)
	public ResponseEntity<Movimientos> GuardarMovimientos(@RequestBody Movimientos mov){
		Movimientos movi = minter.Guardar(mov);
		return ResponseEntity.ok(movi);
	}
	
	/**********************************************/
	/*ELIMINAR*/
	/**********************************************/
	@RequestMapping(value = "movimientos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> EliminarMovimientos(@PathVariable("id") Integer id){ 
		 
		minter.EliminarMovimientos(id);		 
		return ResponseEntity.ok(null);
	} 
	
	/**********************************************/
	/*GET ID*/
	/**********************************************/
	@RequestMapping(value = "movimientos/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Movimientos> MovimientosGetbyId(@PathVariable("id") Integer id){ 
		 
		Optional<Movimientos> optMov = minter.GetIDMovimiento(id); 
		if (optMov.isPresent()) { 
			return ResponseEntity.ok(optMov.get());
		}else { 
			return ResponseEntity.noContent().build();
		}
	}
	
	/**********************************************/
	/*ACTUALIZAR*/
	/**********************************************/
	@PutMapping
	@RequestMapping(value = "movimientos", method = RequestMethod.PUT)
	public ResponseEntity<Movimientos> MovimientosUpdate(@RequestBody Movimientos mov){ 
		 
		 Optional<Movimientos> optMov = minter.GetIDMovimiento(mov.getId_movimientos()); 
		  
		 if (optMov.isPresent()) { 
			  
			 Movimientos movi = optMov.get();  
			  
			 movi.setAlmacen(mov.getAlmacen());
			 movi.setKardex(mov.getKardex());
			 movi.setPedidointerno(mov.getPedidointerno());
			 movi.setInventario(mov.getInventario());
			 movi.setEmpleado(mov.getEmpleado());

			 minter.Guardar(movi); 
			  
			 return ResponseEntity.ok(movi);
			 }else {
				 return ResponseEntity.noContent().build();
			 }
		 
			
		} 
}
