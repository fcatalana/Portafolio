package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Seguro;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.SeguroDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.SeguroServiceAPI;

@Service
public class SeguroServiceImpl extends GenericServiceImpl<Seguro, Long> implements SeguroServiceAPI{

	@Autowired
	private SeguroDaoApi seguroDaoAPI;

	@Override
	public CrudRepository<Seguro, Long> getDao() {
		return seguroDaoAPI;
	}
}
