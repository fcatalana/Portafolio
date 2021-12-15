package com.FeriaVirtual.MaipoGrande.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		@Column
		private Long id_producto;
		
		@Column
		private String nombre_producto;
		
		//@JsonIgnore
		//@ManyToOne(fetch = FetchType.LAZY)
		//@JoinColumn(name="calidad_fruta_id_calidad")
		//private CalidadFruta calidadFruta;
		//private int calidad_fruta_id_calidad;
				
		@Column
		private int valor;
		
		@Column
		private Float existencia;
		
		@Column
		private String codigo;
		
		public Producto(String nombre_producto, 
				int valor, Float existencia, String codigo, Long id_producto) {
	        this.nombre_producto = nombre_producto;	        
	        this.existencia = existencia;	        
	        this.valor = valor;
	        this.existencia = existencia;
	        this.codigo = codigo;
	        this.id_producto = id_producto;
	    }

		public Producto(String nombre_producto, 
				int valor, Float existencia, String codigo) {
	        this.nombre_producto = nombre_producto;	        
	        this.existencia = existencia;	        
	        this.valor = valor;
	        this.existencia = existencia;
	        this.codigo = codigo;
	    }
		
		public Producto() {

		}
		
		public boolean sinExistencia() {
	        return this.existencia <= 0;
	    }
		
		public void restarExistencia(Float existencia) {
	        this.existencia -= existencia;
	    }

		public Long getId_producto() {
			return id_producto;
		}

		public void setId_producto(Long id_producto) {
			this.id_producto = id_producto;
		}

		public String getNombre_producto() {
			return nombre_producto;
		}

		public void setNombre_producto(String nombre_producto) {
			this.nombre_producto = nombre_producto;
		}			

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

		public Float getExistencia() {
			return existencia;
		}

		public void setExistencia(Float existencia) {
			this.existencia = existencia;
		}
		
		public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }
}
