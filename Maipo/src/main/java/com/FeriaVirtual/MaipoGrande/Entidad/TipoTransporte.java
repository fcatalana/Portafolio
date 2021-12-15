package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_transporte")
public class TipoTransporte {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_t_trans;
	
	@Column
	private String nombre_t_trans;

	public TipoTransporte() {
		
	}

	public Long getId_t_trans() {
		return id_t_trans;
	}

	public void setId_t_trans(Long id_t_trans) {
		this.id_t_trans = id_t_trans;
	}

	public String getNombre_t_trans() {
		return nombre_t_trans;
	}

	public void setNombre_t_trans(String nombre_t_trans) {
		this.nombre_t_trans = nombre_t_trans;
	}

	
}
