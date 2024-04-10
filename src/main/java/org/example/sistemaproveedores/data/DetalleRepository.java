package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Detalle;
import org.example.sistemaproveedores.logic.Facturas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Integer> {
}
