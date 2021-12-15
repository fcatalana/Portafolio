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
@Table(name="cliente")
public class Cliente {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_cliente;
	
	@Column
	private String rut_cliente;
	
	@Column
	private String nombre_cliente;
	
	@Column
	private String direccion_cliente;
	
	@Column
	private String telefono_cliente;
	
	@Column
	private String email_cliente;
	
	@Column
	private LocalDate creacion_cliente;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_cliente_id_t_cli")
	private tipoCliente tipocliente;
	//private int tipo_cliente_id_t_cli;
	
	@Column
	private String estado;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contrato_id_contrato")
	private Contrato contrato;
	//private int contrato_id_contrato;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pais_id_pais")
	private Pais pais;
	//private int pais_id_pais;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_usuario")
	private Usuario usuario;

	public Cliente() {

	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getRut_cliente() {
		return rut_cliente;
	}

	public void setRut_cliente(String rut_cliente) {
		this.rut_cliente = rut_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public LocalDate getCreacion_cliente() {
		return creacion_cliente;
	}

	public void setCreacion_cliente(LocalDate creacion_cliente) {
		this.creacion_cliente = creacion_cliente;
	}

	public tipoCliente getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(tipoCliente tipocliente) {
		this.tipocliente = tipocliente;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
		
}
