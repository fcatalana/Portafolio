package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_productor")
public class PedidoProductor {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@OneToOne
	private Pedido pedido;
	
	@OneToOne
	private Productor productor;
	
	@Column
	private String estado;
	
	@Column
	private String fechaYHora;
	
	@OneToOne
	private CalidadFruta calidadFruta;
	
	@Column
	private int monto;

	public PedidoProductor() {
		this.fechaYHora = Utiles.obtenerFechaYHoraActual();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
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

	public CalidadFruta getCalidadFruta() {
		return calidadFruta;
	}

	public void setCalidadFruta(CalidadFruta calidadFruta) {
		this.calidadFruta = calidadFruta;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	
}
