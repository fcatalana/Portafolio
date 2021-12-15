package com.FeriaVirtual.MaipoGrande.Entidad;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fechaYHora;
    
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="estado_pedido_id_estado")
	private EstadoPedido estadoPedido;      
    
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pedido_cliente_id")
	private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ProductoSolicitado> productos;

    public Pedido() {
        this.fechaYHora = Utiles.obtenerFechaYHoraActual();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
    public Set<ProductoSolicitado> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoSolicitado> productos) {
        this.productos = productos;
    }

	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    
}
