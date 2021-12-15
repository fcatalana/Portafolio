package com.FeriaVirtual.MaipoGrande.Entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
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

	
}
