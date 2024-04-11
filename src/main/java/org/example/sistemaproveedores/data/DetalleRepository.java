package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Detalle;
import org.example.sistemaproveedores.logic.Facturas;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Integer> {

    @Query("select c from Detalle c")
    public List<Detalle> findAll();
}
