package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Usuario;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.UsuarioDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioServiceAPI{

	@Autowired
	private UsuarioDaoApi usuarioDaoAPI;
	
	@Override
	public CrudRepository<Usuario, Long> getDao() {		
		return usuarioDaoAPI;
	}

}
