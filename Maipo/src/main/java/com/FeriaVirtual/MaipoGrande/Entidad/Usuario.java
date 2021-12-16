package com.FeriaVirtual.MaipoGrande.Entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	// no tiene constructor, getter y setter por estar @Data. Se debe quitar linea 23 y reemplazar por @Column. Tambien quitar linea 20.
	//se agrega @Column a las otras variables, menos a la lista Rol
	private static final long serialVersionUID=1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column
	private String username;
	
	@Column
	private String clave_usuario;
	
	@Column
	private String rut_usuario;
	
	@Column
	private String nombre_usuario;	
	
	@Column
	private String direccion_usuario;
	
	@Column
	private String telefono_usuario;
	
	@Column
	private String email_usuario;
	
	@Column
	private LocalDate creacion_usuario;
	
	@Column
	private String estado;
	
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Rol> roles;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}

	public String getRut_usuario() {
		return rut_usuario;
	}

	public void setRut_usuario(String rut_usuario) {
		this.rut_usuario = rut_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getDireccion_usuario() {
		return direccion_usuario;
	}

	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public LocalDate getCreacion_usuario() {
		return creacion_usuario;
	}

	public void setCreacion_usuario(LocalDate creacion_usuario) {
		this.creacion_usuario = creacion_usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario() {
		
	}

	
	
}
