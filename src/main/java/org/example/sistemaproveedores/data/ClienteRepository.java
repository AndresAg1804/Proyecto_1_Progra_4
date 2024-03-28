package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, String> {
}
