package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Pedido;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.PedidoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoServiceAPI;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoServiceAPI{

	@Autowired
	private PedidoDaoApi pedidoDaoAPI;

	@Override
	public CrudRepository<Pedido, Long> getDao() {
		return pedidoDaoAPI;
	}
}
