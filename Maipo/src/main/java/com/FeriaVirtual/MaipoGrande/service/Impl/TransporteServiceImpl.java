package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Transporte;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.TransporteDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.TransporteServiceAPI;

@Service
public class TransporteServiceImpl extends GenericServiceImpl<Transporte, Long> implements TransporteServiceAPI{

	@Autowired
	private TransporteDaoApi transporteDaoAPI;

	@Override
	public CrudRepository<Transporte, Long> getDao() {
		return transporteDaoAPI;
	}
}
