package com.FeriaVirtual.MaipoGrande.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FeriaVirtual.MaipoGrande.Entidad.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario,Long>{
	Usuario findByUsername(String username);

}
