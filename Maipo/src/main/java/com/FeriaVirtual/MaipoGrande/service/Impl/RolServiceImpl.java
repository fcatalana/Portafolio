package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Rol;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.RolDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.RolServiceAPI;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolServiceAPI{

	@Autowired
	private RolDaoApi rolDaoAPI;
	
	@Override
	public CrudRepository<Rol, Long> getDao() {
		return rolDaoAPI;
	}

}
