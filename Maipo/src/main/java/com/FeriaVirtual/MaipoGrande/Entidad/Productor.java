package com.FeriaVirtual.MaipoGrande.Entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productor")
public class Productor {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_productor;
	@Column
	private String rut;
	@Column
	private String nombre_productor;
	@Column
	private String direccion_productor;
	@Column
	private String telefono_productor;
	@Column
	private String email_productor;
	@Column
	private LocalDate creacion_productor;
	@Column
	private String estado;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contrato_id_contrato")
	private Contrato contrato;
	//private int contrato_id_contrato;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productor_usuario")
	private Usuario usuario;

	public Productor() {

	}

	public Long getId_productor() {
		return id_productor;
	}

	public void setId_productor(Long id_productor) {
		this.id_productor = id_productor;
	}

	

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre_productor() {
		return nombre_productor;
	}

	public void setNombre_productor(String nombre_productor) {
		this.nombre_productor = nombre_productor;
	}

	public String getDireccion_productor() {
		return direccion_productor;
	}

	public void setDireccion_productor(String direccion_productor) {
		this.direccion_productor = direccion_productor;
	}

	public String getTelefono_productor() {
		return telefono_productor;
	}

	public void setTelefono_productor(String telefono_productor) {
		this.telefono_productor = telefono_productor;
	}

	public String getEmail_productor() {
		return email_productor;
	}

	public void setEmail_productor(String email_productor) {
		this.email_productor = email_productor;
	}

	public LocalDate getCreacion_productor() {
		return creacion_productor;
	}

	public void setCreacion_productor(LocalDate creacion_productor) {
		this.creacion_productor = creacion_productor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

		
}
