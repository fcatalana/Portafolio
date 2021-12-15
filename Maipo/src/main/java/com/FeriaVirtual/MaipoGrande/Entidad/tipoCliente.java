package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_cliente")
public class tipoCliente {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_t_cli;
	
	@Column
	private String tipo_cli;

	public tipoCliente() {
		
	}

	public Long getId_t_cli() {
		return id_t_cli;
	}

	public void setId_t_cli(Long id_t_cli) {
		this.id_t_cli = id_t_cli;
	}

	public String getTipo_cli() {
		return tipo_cli;
	}

	public void setTipo_cli(String tipo_cli) {
		this.tipo_cli = tipo_cli;
	}

	@Override
	public String toString() {
		return "tipoCliente [id_t_cli=" + id_t_cli + ", tipo_cli=" + tipo_cli + "]";
	}

}
