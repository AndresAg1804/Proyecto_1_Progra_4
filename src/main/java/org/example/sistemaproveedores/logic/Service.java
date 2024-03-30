package org.example.sistemaproveedores.logic;


import org.example.sistemaproveedores.data.ClienteRepository;
import org.example.sistemaproveedores.data.ProveedorRepository;
import org.example.sistemaproveedores.data.facturasRepository;
import org.example.sistemaproveedores.data.usuariosRepository;
import org.springframework.beans.factory.annotation.*;

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

    public Iterable<Clientes> clienteFindAll(){
    return clienteRepository.findAll();
}
    public Iterable<Proveedores> proveedorFindAll(){return proveedorRepository.findAll();}
    public Iterable<Usuarios> usuariosFindAll() {return usuarioRepository.findAll();}

    public Iterable<Facturas> facturasFindAll() {return facturasRepository.findAll();}
    public void addUsuario(String usern, String pasw, String tipo) {
    Usuarios u=new Usuarios();
    u.setUsern(usern);
    u.setPasw(pasw);
    u.setTipo(tipo);
    usuarioRepository.save(u);
    }


}
