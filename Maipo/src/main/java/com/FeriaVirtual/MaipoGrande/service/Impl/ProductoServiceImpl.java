package com.FeriaVirtual.MaipoGrande.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.FeriaVirtual.MaipoGrande.Entidad.Producto;
import com.FeriaVirtual.MaipoGrande.commons.GenericServiceImpl;
import com.FeriaVirtual.MaipoGrande.dao.api.ProductoDaoApi;
import com.FeriaVirtual.MaipoGrande.service.api.ProductoServiceAPI;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoServiceAPI{

	@Autowired
	private ProductoDaoApi productoDaoAPI;

	@Override
	public CrudRepository<Producto, Long> getDao() {
		// TODO Auto-generated method stub
		return productoDaoAPI;
	}
	
	

}
