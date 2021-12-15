package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.TipoTransporte;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.TipoTransporteDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.TipoTransporteServiceAPI;

@Service
public class TipoTransporteServiceImpl extends GenericServiceImpl<TipoTransporte, Long> implements TipoTransporteServiceAPI{

	@Autowired
	private TipoTransporteDaoApi tipoTransporteDaoAPI;

	@Override
	public CrudRepository<TipoTransporte, Long> getDao() {
		return tipoTransporteDaoAPI;
	}
}
