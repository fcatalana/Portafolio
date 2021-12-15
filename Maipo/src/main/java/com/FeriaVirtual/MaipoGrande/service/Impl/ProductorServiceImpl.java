package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Productor;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.ProductorDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.ProductorServiceAPI;

@Service
public class ProductorServiceImpl extends GenericServiceImpl<Productor, Long> implements ProductorServiceAPI{

	@Autowired
	private ProductorDaoApi productorDaoAPI;

	@Override
	public CrudRepository<Productor, Long> getDao() {
		// TODO Auto-generated method stub
		return productorDaoAPI;
	}
	
	

}
