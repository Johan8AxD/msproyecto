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
@Table(name="tbl_kardex")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Kardex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Kardex;
	private String nom_kardex;
	

}
