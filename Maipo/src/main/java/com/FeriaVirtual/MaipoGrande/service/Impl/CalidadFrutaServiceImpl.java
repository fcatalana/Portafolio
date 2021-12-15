package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.CalidadFruta;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.CalidadFrutaDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.CalidadFrutaServiceAPI;

@Service
public class CalidadFrutaServiceImpl extends GenericServiceImpl<CalidadFruta, Long> implements CalidadFrutaServiceAPI{
	
	@Autowired
	private CalidadFrutaDaoApi calidadFrutaDaoAPI;

	@Override
	public CrudRepository<CalidadFruta, Long> getDao() {
		return calidadFrutaDaoAPI;
	}

}
