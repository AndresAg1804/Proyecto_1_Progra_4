package org.example.sistemaproveedores.data;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.stereotype.Repository;
import org.example.sistemaproveedores.logic.Producto;

import java.util.List;

@Repository
public interface ProductosRepository extends CrudRepository<Producto, String>{

    Producto findByIdprAndProveedoresByIdProd(String idproducto, Proveedores proveedor);
    @Query("select p from Producto p where p.proveedoresByIdProd.idp=?1")
    List<Producto> get_all_productos_de_IDprovedor(String idproveedor);

    @Transactional
    @Modifying
    @Query("update Producto p set p.nombrep = ?1, p.precio = ?2, p.cant = ?3 where p.idpr = ?4")
    void updateProducto(String nombrep, double precio, int cantidad, String idpr);



}
