package org.example.sistemaproveedores.data;

import org.example.sistemaproveedores.logic.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuariosRepository extends CrudRepository<Usuarios, String> {
    Usuarios findByUsernAndPasw(String usern,String pasw);
    Usuarios findByUsern(String username);


}
