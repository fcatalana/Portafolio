package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="transporte")
public class Transporte {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_trans;
	
	@Column
	private String nombre_transporte;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_transporte_id_t_trans")
	private TipoTransporte tipoTransporte;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="seguro_id_seguro")
	private Seguro seguro;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transporte_usuario")
	private Usuario usuario;

	public Transporte() {

	}

	public Long getId_trans() {
		return id_trans;
	}

	public void setId_trans(Long id_trans) {
		this.id_trans = id_trans;
	}

	public String getNombre_transporte() {
		return nombre_transporte;
	}

	public void setNombre_transporte(String nombre_transporte) {
		this.nombre_transporte = nombre_transporte;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
