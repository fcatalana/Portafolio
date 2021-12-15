package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductoSolicitado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float cantidad;
    private String nombre, codigo;
    @ManyToOne
    @JoinColumn
    private Pedido pedido;
    
    public ProductoSolicitado(Float cantidad, String nombre, String codigo, Pedido pedido) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.codigo = codigo;
        this.pedido = pedido;
    }

    public ProductoSolicitado() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setVenta(Pedido pedido) {
        this.pedido = pedido;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
    
    
}
