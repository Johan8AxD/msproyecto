package com.almacen.controlador;

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

import com.almacen.Entidad.Inventario;
import com.almacen.Interfaces.InventarioInterfaces;

@Controller
@RequestMapping(name="/")
public class InventarioController {
	
	@Autowired
	private InventarioInterfaces iinter;
	
	/**********************************************/
	/*LISTAR*/
	/**********************************************/
	@RequestMapping(value = "/listarinventario", method = RequestMethod.GET)
	public ResponseEntity<List<Inventario>> InventarioLst(){ 
		 
		List<Inventario> inv = iinter.lstInv(); 
		return ResponseEntity.ok(inv);
	}
	
	/**********************************************/
	/*GUARDAR*/
	/**********************************************/
	@RequestMapping(value = "guardarinventario", method = RequestMethod.POST)
	public ResponseEntity<Inventario> GuardarInventario(@RequestBody Inventario inve){
		Inventario inv= iinter.Guardar(inve);
		return ResponseEntity.ok(inv);
	}
	
	/**********************************************/
	/*ELIMINAR*/
	/**********************************************/
	@RequestMapping(value = "inventario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> EliminarInventario(@PathVariable("id") Integer id){ 
		iinter.EliminarInvetario(id); 
		return ResponseEntity.ok(null);
	} 
	
	/**********************************************/
	/*GET ID*/
	/**********************************************/
	@RequestMapping(value = "inventario/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Inventario> InventarioGetbyId(@PathVariable("id") Integer id){ 
		 
		Optional<Inventario> optInv = iinter.GetIDInventario(id); 
		if (optInv.isPresent()) { 
			return ResponseEntity.ok(optInv.get());
		}else { 
			return ResponseEntity.noContent().build();
		}
	}
	
	/**********************************************/
	/*ACTUALIZAR*/
	/**********************************************/
	@PutMapping
	@RequestMapping(value = "inventario", method = RequestMethod.PUT)
	public ResponseEntity<Inventario> InventarioUpdate(@RequestBody Inventario inve){ 
		 
		 Optional<Inventario> optInv = iinter.GetIDInventario(inve.getId_inventario()); 
		  
		 if (optInv.isPresent()) { 
			  
			 Inventario inv = optInv.get();  
			  
			 inv.setNom_inventario(inve.getNom_inventario()); 

			 iinter.Guardar(inv); 
			  
			 return ResponseEntity.ok(inv);
			 }else {
				 return ResponseEntity.noContent().build();
			 }	
		}
}
