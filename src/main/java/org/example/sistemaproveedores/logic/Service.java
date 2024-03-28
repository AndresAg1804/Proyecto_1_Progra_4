package org.example.sistemaproveedores.logic;


import org.example.sistemaproveedores.data.ClienteRepository;
import org.example.sistemaproveedores.data.ProveedorRepository;
import org.springframework.beans.factory.annotation.*;

@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;

public Iterable<Clientes> clienteFindAll(){
    return clienteRepository.findAll();
}
public Iterable<Proveedores> proveedorFindAll(){return proveedorRepository.findAll();}
    
}
