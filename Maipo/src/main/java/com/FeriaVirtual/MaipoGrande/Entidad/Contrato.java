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

import lombok.Data;

@Data
@Entity
@Table(name="contrato")
public class Contrato {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_contrato;
	
	@Column
	private String descripcion_contra;
	
	@Column
	private LocalDate inicio_contra;
	
	@Column
	private LocalDate termino_contra;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_contrato_id_t_contra")
	private tipoContrato tipocontrato;
	//private int tipo_contrato_id_t_contra;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="estado_contrato_id_est_contra")
	private estadoContrato estadocontrato;
	//private int estado_contrato_id_est_contra;
	
	
		
}
