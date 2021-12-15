package com.FeriaVirtual.MaipoGrande.Entidad;

public class ProductoParaVender extends Producto {
    private Float cantidad;

	public ProductoParaVender(String nombre_producto,
			int valor, Float existencia, String codigo, Long id_producto, Float cantidad) {
		super(nombre_producto, valor, existencia, codigo, id_producto);
		this.cantidad = cantidad;
	}

	public ProductoParaVender(String nombre_producto,
			int valor, Float existencia, String codigo,Float cantidad) {
		super(nombre_producto, valor, existencia, codigo);
		this.cantidad = cantidad;
	}

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getTotal() {
        return this.getValor() * this.cantidad;
    }
}
