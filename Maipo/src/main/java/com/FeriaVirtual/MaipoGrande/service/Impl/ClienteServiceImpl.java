package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Cliente;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.ClienteDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.ClienteServiceAPI;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteServiceAPI{

	@Autowired
	private ClienteDaoApi clienteDaoAPI;
	
	@Override
	public CrudRepository<Cliente, Long> getDao() {

		return clienteDaoAPI;
	}

}
