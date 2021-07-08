package com.almacen.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacen.Entidad.PedidoInterno;
import com.almacen.Interfaces.PedidoInternoInterfaces;
import com.almacen.Repositorio.PedidoInternoRepositorio;

@Service
public class PedidoInternoServicio implements PedidoInternoInterfaces{

	@Autowired
	private PedidoInternoRepositorio prepos;
	
	@Override
	public List<PedidoInterno> lstPedido() {
		List<PedidoInterno> pedi = prepos.findAll();
		return pedi;
	}

}
