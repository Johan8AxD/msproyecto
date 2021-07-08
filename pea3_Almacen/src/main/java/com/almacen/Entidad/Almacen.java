package com.almacen.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_almacen")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Almacen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_almacen;
	private String nom_almacen;
	
	
	
}
