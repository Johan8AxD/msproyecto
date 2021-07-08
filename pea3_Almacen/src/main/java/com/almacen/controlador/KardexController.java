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

import com.almacen.Entidad.Kardex;
import com.almacen.Interfaces.KardexInterfaces;

@Controller
@RequestMapping(name="/")
public class KardexController {
	@Autowired 
	private KardexInterfaces kinter;
	
	
	/**********************************************/
	/*LISTAR*/
	/**********************************************/
	@RequestMapping(value = "/listarkardex", method = RequestMethod.GET)
	public ResponseEntity<List<Kardex>> KardexLst(){ 
		 
		List<Kardex> kar = kinter.lstKar(); 
		return ResponseEntity.ok(kar);
	}
	
	/**********************************************/
	/*GUARDAR*/
	/**********************************************/
	@RequestMapping(value = "guardarkardex", method = RequestMethod.POST)
	public ResponseEntity<Kardex> GuardarKardex(@RequestBody Kardex kard){
		Kardex kar= kinter.Guardar(kard);
		return ResponseEntity.ok(kar);
	}
	
	/**********************************************/
	/*ELIMINAR*/
	/**********************************************/
	@RequestMapping(value = "kardex/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> EliminarKardex(@PathVariable("id") Integer id){ 
		 
		kinter.EliminarKardex(id); 
		 
		return ResponseEntity.ok(null);
	} 
	
	/**********************************************/
	/*GET ID*/
	/**********************************************/
	@RequestMapping(value = "kardex/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Kardex> KardexGetbyId(@PathVariable("id") Integer id){ 
		 
		Optional<Kardex> optkar = kinter.GetIDKardex(id); 
		if (optkar.isPresent()) { 
			return ResponseEntity.ok(optkar.get());
		}else { 
			return ResponseEntity.noContent().build();
		}
	}
	
	/**********************************************/
	/*ACTUALIZAR*/
	/**********************************************/
	@PutMapping
	@RequestMapping(value = "kardex", method = RequestMethod.PUT)
	public ResponseEntity<Kardex> KardexUpdate(@RequestBody Kardex kar){ 
		 
		 Optional<Kardex> optKar = kinter.GetIDKardex(kar.getId_Kardex()); 
		  
		 if (optKar.isPresent()) { 
			  
			 Kardex ka = optKar.get();  
			  
			 ka.setNom_kardex(kar.getNom_kardex()); 

			 kinter.Guardar(ka); 
			  
			 return ResponseEntity.ok(ka);
			 }else {
				 return ResponseEntity.noContent().build();
			 }	
		}
}
