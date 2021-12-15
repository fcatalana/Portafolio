package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.tipoCliente;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.tipoClienteDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.tipoClienteServiceAPI;

@Service
public class tipoClienteServiceImpl extends GenericServiceImpl<tipoCliente, Long> implements tipoClienteServiceAPI{

	@Autowired
	private tipoClienteDaoApi tipoClienteDaoAPI;
	
	@Override
	public CrudRepository<tipoCliente, Long> getDao() {
		return tipoClienteDaoAPI;
	}

}
