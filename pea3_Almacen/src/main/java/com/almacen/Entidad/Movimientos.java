package com.almacen.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tbl_movimientos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_movimientos;
	
	@ManyToOne
	@JoinColumn (name = "almacen")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn (name = "kardex")
	private Kardex kardex;
	
	@ManyToOne
	@JoinColumn (name = "pedidointerno")
	private PedidoInterno pedidointerno;
	
	@ManyToOne
	@JoinColumn (name = "inventario")
	private Inventario inventario;
	
	@ManyToOne
	@JoinColumn (name = "empleados")
	private Empleado empleado;

	
	

}
