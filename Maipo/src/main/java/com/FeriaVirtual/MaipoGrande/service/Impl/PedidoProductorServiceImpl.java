package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.PedidoProductor;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.PedidoProductorDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoProductorServiceAPI;

@Service
public class PedidoProductorServiceImpl extends GenericServiceImpl<PedidoProductor, Long> implements PedidoProductorServiceAPI{

	@Autowired
	private PedidoProductorDaoApi pedidoProductorDaoAPI;

	@Override
	public CrudRepository<PedidoProductor, Long> getDao() {
		return pedidoProductorDaoAPI;
	}
}
