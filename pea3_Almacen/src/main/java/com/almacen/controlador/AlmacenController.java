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

import com.almacen.Entidad.Almacen;
import com.almacen.Interfaces.AlmacenInterfaces;

@Controller
@RequestMapping(name="/")
public class AlmacenController {
	@Autowired 
	private AlmacenInterfaces almaceni;
	
	
	/**********************************************/
	/*LISTAR*/
	/**********************************************/
	@RequestMapping(value = "/listaralmacen", method = RequestMethod.GET)
	public ResponseEntity<List<Almacen>> AlmacenLst(){ 
		 
		List<Almacen> almac = almaceni.lstAlmc(); 
		return ResponseEntity.ok(almac);
	}
	
	/**********************************************/
	/*GUARDAR*/
	/**********************************************/
	@RequestMapping(value = "guardaralmacen", method = RequestMethod.POST)
	public ResponseEntity<Almacen> GuardarAlmacen(@RequestBody Almacen alm){
		Almacen al= almaceni.Guardar(alm);
		return ResponseEntity.ok(al);
	}
	
	/**********************************************/
	/*ELIMINAR*/
	/**********************************************/
	@RequestMapping(value = "almacen/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> EliminarAlmacen(@PathVariable("id") Integer id){ 
		 
		almaceni.EliminarAlmacen(id); 
		 
		return ResponseEntity.ok(null);
	} 
	
	/**********************************************/
	/*GET ID*/
	/**********************************************/
	@RequestMapping(value = "almacen/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Almacen> KardexGetbyId(@PathVariable("id") Integer id){ 
		 
		Optional<Almacen> optAlm = almaceni.GetIDAlmacen(id); 
		if (optAlm.isPresent()) { 
			return ResponseEntity.ok(optAlm.get());
		}else { 
			return ResponseEntity.noContent().build();
		}
	}
	
	/**********************************************/
	/*ACTUALIZAR*/
	/**********************************************/
	@PutMapping
	@RequestMapping(value = "almacen", method = RequestMethod.PUT)
	public ResponseEntity<Almacen> AlmacenUpdate(@RequestBody Almacen alm){ 
		 
		 Optional<Almacen> optAlm = almaceni.GetIDAlmacen(alm.getId_almacen()); 
		  
		 if (optAlm.isPresent()) { 
			  
			 Almacen al = optAlm.get();  
			  
			 al.setNom_almacen(alm.getNom_almacen()); 

			 almaceni.Guardar(al); 
			  
			 return ResponseEntity.ok(al);
			 }else {
				 return ResponseEntity.noContent().build();
			 }
		 
			
		} 
}
