package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.*;

@Entity
public class ProductoVendido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float cantidad;
    private int valor;
    private String nombre, codigo;
    @ManyToOne
    @JoinColumn
    private Venta venta;

    public ProductoVendido(Float cantidad, int valor, String nombre, String codigo, Venta venta) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.nombre = nombre;
        this.codigo = codigo;
        this.venta = venta;
    }

    public ProductoVendido() {
    }

    public Float getTotal() {
        return this.cantidad * this.valor;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
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
}
