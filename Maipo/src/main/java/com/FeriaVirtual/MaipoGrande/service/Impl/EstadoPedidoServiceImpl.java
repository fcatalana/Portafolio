package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.EstadoPedido;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.EstadoPedidoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.EstadoPedidoServiceAPI;

@Service
public class EstadoPedidoServiceImpl extends GenericServiceImpl<EstadoPedido, Long> implements EstadoPedidoServiceAPI{

	@Autowired
	private EstadoPedidoDaoApi estadoPedidoDaoAPI;
	
	@Override
	public CrudRepository<EstadoPedido, Long> getDao() {
		return estadoPedidoDaoAPI;
	}

}
