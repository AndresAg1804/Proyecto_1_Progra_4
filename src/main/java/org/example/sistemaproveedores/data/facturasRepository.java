package org.example.sistemaproveedores.data;


import org.example.sistemaproveedores.logic.Facturas;
import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface facturasRepository extends CrudRepository<Facturas, Integer> {

    ArrayList<Facturas> findFacturasByProveedoresByIdProveedor(Proveedores prov);
    @Transactional
    @Modifying
    @Query("SELECT f FROM Facturas f WHERE f.proveedoresByIdProveedor.idP = ?1")
    List<Facturas> findAllByProveedorId(String idproveedor);
}
