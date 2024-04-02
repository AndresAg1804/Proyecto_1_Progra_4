package org.example.sistemaproveedores.presentation.Facturar;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@org.springframework.stereotype.Controller("Facturar")
@SessionAttributes({ "Facturar","ProductosVentaS","cliente"})
public class Controller {


    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show(HttpSession session, Model model) {
        //model.addAttribute("ProductosVenta", new ArrayList<Producto>());
        Clientes clienteP=null;
        ArrayList<Producto> productosP=null;
        try{
            clienteP=(Clientes)session.getAttribute("cliente");
        }catch (Exception e){
            clienteP=new Clientes();
        }
        session.setAttribute("cliente", clienteP);

        try{
            productosP=(ArrayList<Producto>)session.getAttribute("ProductosVentaS");
        }catch(Exception f){
            productosP=new ArrayList<Producto>();
        }
        session.setAttribute("ProductosVentaS", productosP);


        return "Presentation/Facturar/view";
    }

    @GetMapping ("/presentation/Facturar/FindClient") //Busqueda de cliente para facturar
    public String findUserByID(@RequestParam("nombreC") String id, Model model, HttpSession session){
        //model.addAttribute("cliente", service.clienteFindByID(id));
        Usuarios u= (Usuarios) session.getAttribute("usuario");
        Proveedores p= u.getProveedoresByIdprov();

        Clientes cjp=service.clienteFindByIDyProvedor(id, p);
        session.setAttribute("cliente", cjp);

        return "Presentation/Facturar/view";
    }
    @GetMapping ("/presentation/Facturar/AddProduct")
    public String findProducto(HttpSession session, @RequestParam("idP") String idProducto){
        Usuarios u= (Usuarios) session.getAttribute("usuario");
        Proveedores p= u.getProveedoresByIdprov();
        ArrayList<Producto> productosP=null;
        try{
            productosP=(ArrayList<Producto>)session.getAttribute("ProductosVentaS");
            productosP.add(service.findProdByIdAndProveedor(idProducto,p));
        }catch(Exception f){
            productosP=new ArrayList<Producto>();
            productosP.add(service.findProdByIdAndProveedor(idProducto,p));
        }
        session.setAttribute("ProductosVentaS", productosP);
        return "Presentation/Facturar/view";
    }
}
