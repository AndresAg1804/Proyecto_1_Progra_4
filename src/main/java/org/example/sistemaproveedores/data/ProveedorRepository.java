package org.example.sistemaproveedores.data;


import org.example.sistemaproveedores.logic.Proveedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProveedorRepository extends CrudRepository<Proveedores, String>{

}
