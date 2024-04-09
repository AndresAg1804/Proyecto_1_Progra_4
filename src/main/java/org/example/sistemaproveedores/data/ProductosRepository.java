package org.example.sistemaproveedores.data;


import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.sistemaproveedores.logic.Producto;
@Repository
public interface ProductosRepository extends CrudRepository<Producto, String>{

    Producto findByIdPrAndProveedoresByIdProd(String idProducto, Proveedores proveedor);
    //Producto findProductoByProveedoresByIdProd(String idProvedor);
}
