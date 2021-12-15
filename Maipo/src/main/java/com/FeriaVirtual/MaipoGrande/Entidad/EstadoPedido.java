package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_pedido")
public class EstadoPedido {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_estado;
	
	@Column
	private String estado_pedido;

	public EstadoPedido() {
		
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public String getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	
	
}
