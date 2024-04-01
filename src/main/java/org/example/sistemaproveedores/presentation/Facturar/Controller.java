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

    @ModelAttribute("Facturar")
    public ArrayList<Producto> productosVenta() {return new ArrayList<Producto>();}


    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show(HttpSession session, Model model) {
        //model.addAttribute("ProductosVenta", new ArrayList<Producto>());
        Clientes cjp=null;
        try{
            cjp=(Clientes)session.getAttribute("cliente");
        }catch (Exception e){
            cjp=new Clientes();
            cjp.setIdC("Juan");
            cjp.setNombreC("Juan");
        }
        session.setAttribute("cliente", cjp);


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

}
