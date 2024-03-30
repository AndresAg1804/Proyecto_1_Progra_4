package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Clientes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, String> {

    @Query("select c from Clientes c where c.proveedoresByProveedorid.idP=?1")
    List<Clientes> findClientesByProveedor(String idProveedor);



}
