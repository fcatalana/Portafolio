package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_pais;
	
	@Column
	private String nombre_pais;

	public Pais() {
		
	}

	public Long getId_pais() {
		return id_pais;
	}

	public void setId_pais(Long id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", nombre_pais=" + nombre_pais + "]";
	}
	
	
}
