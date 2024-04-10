package org.example.sistemaproveedores.data;


import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.sistemaproveedores.logic.Producto;

import java.util.List;

@Repository
public interface ProductosRepository extends CrudRepository<Producto, String>{

    Producto findByIdPrAndProveedoresByIdProd(String idProducto, Proveedores proveedor);
    @Query("select p from Producto p where p.proveedoresByIdProd.idP=?1")
    List<Producto> get_all_productos_de_IDprovedor(String idProveedor);


}
