package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_contrato")
public class estadoContrato {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_est_contra;
	
	@Column
	private String estado_contra;

	public estadoContrato() {
		
	}

	public Long getId_est_contra() {
		return id_est_contra;
	}

	public void setId_est_contra(Long id_est_contra) {
		this.id_est_contra = id_est_contra;
	}

	public String getEstado_contra() {
		return estado_contra;
	}

	public void setEstado_contra(String estado_contra) {
		this.estado_contra = estado_contra;
	}

	@Override
	public String toString() {
		return "estadoContrato [id_est_contra=" + id_est_contra + ", estado_contra=" + estado_contra + "]";
	}

	
}
