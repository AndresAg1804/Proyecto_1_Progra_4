package org.example.sistemaproveedores.logic;


import ch.qos.logback.core.net.server.Client;
import org.example.sistemaproveedores.data.ClienteRepository;
import org.example.sistemaproveedores.data.ProveedorRepository;
import org.example.sistemaproveedores.data.facturasRepository;
import org.example.sistemaproveedores.data.usuariosRepository;
import org.example.sistemaproveedores.data.ProductosRepository;
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
    @Autowired
    private ProductosRepository productosRepository;

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

    public Clientes clienteFindByIDyProvedor(String idc, Proveedores proveedores){
        return clienteRepository.findByIdCAndProveedoresByProveedorid(idc,proveedores);
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

    public Usuarios addUsuario(String usern, String pasw, String tipo,String nombreP,String idP) {
        Proveedores p=new Proveedores();
        p.setNombreP(nombreP);
        p.setIdP(idP);
        p.setAprobado((byte) 0);//0=fals 1=true
        proveedorRepository.save(p);
    Usuarios u=new Usuarios();
    u.setUsern(usern);
    u.setPasw(pasw);
    u.setTipo(tipo);
    u.setProveedoresByIdprov(p);
    usuarioRepository.save(u);
    return u;
    }

    public boolean existeU(String us){
        return usuarioRepository.existsById(us);
    }

    public Usuarios login(String usern,String pasw){
        if(existeU(usern)==true){
            return usuarioRepository.findByUsernAndPasw(usern,pasw);
        }
        return null;
    }

    public void changePRO(String username){
        Usuarios u=null;
        if(existeU(username)==true) {
            u = usuarioRepository.findByUsern(username);
            if (u.getProveedoresByIdprov().getAprobado().equals((byte) 0)) {
                u.getProveedoresByIdprov().setAprobado((byte) 1);
            } else {
                u.getProveedoresByIdprov().setAprobado((byte) 0);//boole
            }
            usuarioRepository.save(u);
        }
        //          1=true;
        //          0=false;
    };

    //Metodos para facturas
    public Iterable<Facturas> findFacturasByIdProveedor(Proveedores prov){
        return facturasRepository.findFacturasByProveedoresByIdProveedor(prov);
    }

    //Metodos para productos
    public Producto findProdByIdAndProveedor(String id, Proveedores prov){
        return productosRepository.findByIdPrAndProveedoresByIdProd(id,prov);
    }

}
