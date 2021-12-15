package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Pais;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.PaisDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.PaisServiceAPI;

@Service
public class PaisServiceImpl extends GenericServiceImpl<Pais, Long> implements PaisServiceAPI{

	@Autowired
	private PaisDaoApi paisDaoAPI;
	
	@Override
	public CrudRepository<Pais, Long> getDao() {
		return paisDaoAPI;
	}

}
