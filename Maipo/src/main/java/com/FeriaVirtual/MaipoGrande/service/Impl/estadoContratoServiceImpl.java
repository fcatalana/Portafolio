package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.estadoContrato;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.estadoContratoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.estadoContratoServiceAPI;

@Service
public class estadoContratoServiceImpl extends GenericServiceImpl<estadoContrato, Long> implements estadoContratoServiceAPI{

	@Autowired
	private estadoContratoDaoApi estadocontratoDaoAPI;

	@Override
	public CrudRepository<estadoContrato, Long> getDao() {
		return estadocontratoDaoAPI;
	}
}
