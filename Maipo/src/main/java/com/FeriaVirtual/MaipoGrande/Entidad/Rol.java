package com.FeriaVirtual.MaipoGrande.Entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
	// no tiene constructor, getter y setter por estar @Data. Se debe quitar linea 23 y reemplazar por @Column, tambien comentar linea 20.
	//se agrega @Column a las otras variables
	private static final long serialVersionUID=1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	
	@Column
	private String nombre_rol;
	
	@Column
	private LocalDate creacion_rol;
	
}
