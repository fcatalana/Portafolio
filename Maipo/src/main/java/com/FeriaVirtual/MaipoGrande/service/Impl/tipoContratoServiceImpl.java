package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.tipoContrato;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.tipoContratoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.tipoContratoServiceAPI;

@Service
public class tipoContratoServiceImpl extends GenericServiceImpl<tipoContrato, Long> implements tipoContratoServiceAPI{

	@Autowired
	private tipoContratoDaoApi tipocontratoDaoAPI;
	
	@Override
	public CrudRepository<tipoContrato, Long> getDao() {
		return tipocontratoDaoAPI;
	}

}
