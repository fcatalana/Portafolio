package com.FeriaVirtual.MaipoGrande.service.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FeriaVirtual.MaipoGrande.Entidad.Rol;
import com.FeriaVirtual.MaipoGrande.Entidad.Usuario;
import com.FeriaVirtual.MaipoGrande.dao.api.UsuarioDAO;

@Service("userDetailsService")
public class UsuarioImplement implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Usuario user=usuarioDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		var roles = new ArrayList<GrantedAuthority>();
		for(Rol rol: user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre_rol()));//nombre
			//del tipo de usuario
		}
		
		return new User(user.getUsername(),user.getClave_usuario(),roles);
		//return un nuevo Usuario - username, password - roles
	}
}
