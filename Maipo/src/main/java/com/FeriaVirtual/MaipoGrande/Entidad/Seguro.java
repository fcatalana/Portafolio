package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seguro")
public class Seguro {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_seguro;
	
	@Column
	private String nombre_seguro;

	public Seguro() {
		
	}

	public Long getId_seguro() {
		return id_seguro;
	}

	public void setId_seguro(Long id_seguro) {
		this.id_seguro = id_seguro;
	}

	public String getNombre_seguro() {
		return nombre_seguro;
	}

	public void setNombre_seguro(String nombre_seguro) {
		this.nombre_seguro = nombre_seguro;
	}
	
	
}
