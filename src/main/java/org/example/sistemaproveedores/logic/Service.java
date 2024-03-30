package org.example.sistemaproveedores.logic;


import ch.qos.logback.core.net.server.Client;
import org.example.sistemaproveedores.data.ClienteRepository;
import org.example.sistemaproveedores.data.ProveedorRepository;
import org.example.sistemaproveedores.data.facturasRepository;
import org.example.sistemaproveedores.data.usuariosRepository;
import org.springframework.beans.factory.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private usuariosRepository usuarioRepository;
    @Autowired
    private facturasRepository facturasRepository;

    //Metodos para clientes
    public Iterable<Clientes> clienteFindAll(){
    return clienteRepository.findAll();
    }
    public Optional<Clientes> clienteFindByID(String id){
        return clienteRepository.findById(id); 
    }

    public Iterable<Clientes> clienteFindByProveedor(String idProveedor){
        return clienteRepository.findClientesByProveedor(idProveedor);
    }

    public void addCliente(String nombreC, String idC, String correo, int telefono, Proveedores proveedor){
        Clientes c=new Clientes();
        c.setIdC(idC);
        c.setNombreC(nombreC);
        c.setCorreo(correo);
        c.setTelefono(telefono);
        c.setProveedoresByProveedorid(proveedor); //Fijarse que sea correcto
        clienteRepository.save(c);
    }

    //Metodos para proveedores
    public Iterable<Proveedores> proveedorFindAll(){return proveedorRepository.findAll();}

    //Metodos para usuarios
    public Iterable<Usuarios> usuariosFindAll() {return usuarioRepository.findAll();}

    public void addUsuario(String usern, String pasw, String tipo) {
    Usuarios u=new Usuarios();
    u.setUsern(usern);
    u.setPasw(pasw);
    u.setTipo(tipo);
    usuarioRepository.save(u);
    }


    //Metodos para facturas
    public Iterable<Facturas> facturasFindAll() {return facturasRepository.findAll();}

}
