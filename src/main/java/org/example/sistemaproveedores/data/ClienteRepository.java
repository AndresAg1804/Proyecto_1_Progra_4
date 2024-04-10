package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, String> {

    @Query("select c from Clientes c where c.proveedoresByProveedorid.idp=?1")
    List<Clientes> findClientesByProveedor(String idproveedor);

    Clientes findByIdcAndProveedoresByProveedorid(String idc, Proveedores proveedores);

}
