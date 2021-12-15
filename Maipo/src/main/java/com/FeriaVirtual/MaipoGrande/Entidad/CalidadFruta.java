package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calidad_fruta")
public class CalidadFruta {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_calidad;
	
	@Column
	private String calidad;

	public CalidadFruta() {
		
	}

	public Long getId_calidad() {
		return id_calidad;
	}

	public void setId_calidad(Long id_calidad) {
		this.id_calidad = id_calidad;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "CalidadFruta [id_calidad=" + id_calidad + ", calidad=" + calidad + "]";
	}
	
	

}
