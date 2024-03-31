package org.example.sistemaproveedores.presentation.Facturar;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Producto;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@SessionAttributes({"clienteFind", "ProductosVenta","proveedor"})
@org.springframework.stereotype.Controller("Facturar")
public class Controller {
    @ModelAttribute("clienteFind")
    public Clientes clientefind() {return new Clientes(); }
    @ModelAttribute("ProductosVenta")
    public Iterable<Producto> productosVenta() {return new ArrayList<Producto>();}

    @ModelAttribute("proveedor")
    public Proveedores proveedor() {return new Proveedores(); }


    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show(HttpSession httpSession, Model model) {
        Proveedores u=new Proveedores();
            u.setIdP("2555");
            u.setNombreP("Pedro palotes");
            u.setAprobado((byte) 1);
            model.addAttribute("proveedor",u);
            httpSession.setAttribute("proveedor", u);

        return "Presentation/Facturar/view";
    }

    @GetMapping ("/presentation/Facturar/FindClient") //Busqueda de cliente para facturar
    public String findUserByID(@RequestParam("nombreC") String id, Model model, HttpSession httpSession){
        //model.addAttribute("clienteFind", service.clienteFindByID(id));
        Clientes c=new Clientes();
        c.setNombreC("judas");
        model.addAttribute("clienteFind",c);
        httpSession.setAttribute("clienteFind",c);
        return "redirect:/presentation/Facturar/show";
    }

}
