package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.SubastaTransporte;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.SubastaTransporteDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.SubastaTransporteServiceAPI;

@Service
public class SubastaTransporteServiceImpl extends GenericServiceImpl<SubastaTransporte, Long> implements SubastaTransporteServiceAPI{

	@Autowired
	private SubastaTransporteDaoApi subastaTransporteDaoAPI;

	@Override
	public CrudRepository<SubastaTransporte, Long> getDao() {
		return subastaTransporteDaoAPI;
	}
}
