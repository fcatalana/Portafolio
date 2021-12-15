package com.FeriaVirtual.MaipoGrande.Repository;

import org.springframework.data.repository.CrudRepository;

import com.FeriaVirtual.MaipoGrande.Entidad.Producto;

public interface ProductosRepository extends CrudRepository<Producto, Long> {

    Producto findFirstByCodigo(String codigo);
}
