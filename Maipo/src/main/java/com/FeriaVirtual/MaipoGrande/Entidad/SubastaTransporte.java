package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subasta_transporte")
public class SubastaTransporte {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@OneToOne
	private PedidoProductor pedidoProductor;
	
	@OneToOne
	private Transporte transporte;
	
	@Column
	private String estado;
	
	@Column
	private String fechaYHora;		
	
	@Column
	private int monto;

	public SubastaTransporte() {
		this.fechaYHora = Utiles.obtenerFechaYHoraActual();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PedidoProductor getPedidoProductor() {
		return pedidoProductor;
	}

	public void setPedidoProductor(PedidoProductor pedidoProductor) {
		this.pedidoProductor = pedidoProductor;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	

}
