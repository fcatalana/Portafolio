package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_contrato")
public class tipoContrato {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_t_contra;
	
	@Column
	private String descripcion;

	public tipoContrato() {
		
	}

	public Long getId_t_contra() {
		return id_t_contra;
	}

	public void setId_t_contra(Long id_t_contra) {
		this.id_t_contra = id_t_contra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "tipoContrato [id_t_contra=" + id_t_contra + ", descripcion=" + descripcion + "]";
	}
	
	

}
