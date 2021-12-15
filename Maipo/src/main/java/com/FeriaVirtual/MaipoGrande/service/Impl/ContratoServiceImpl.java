package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Contrato;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.ContratoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.ContratoServiceAPI;

@Service
public class ContratoServiceImpl extends GenericServiceImpl<Contrato, Long> implements ContratoServiceAPI{

	@Autowired
	private ContratoDaoApi contratoDaoAPI;
	
	@Override
	public CrudRepository<Contrato, Long> getDao() {
		return contratoDaoAPI;
	}

}
