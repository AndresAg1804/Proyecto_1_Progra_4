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


@SessionAttributes({ "ProductosVentaS"})
@org.springframework.stereotype.Controller("Facturar")
public class Controller {
    @ModelAttribute("cliente")
    public Clientes clientefind() {return new Clientes(); }
    @ModelAttribute("ProductosVenta")
    public ArrayList<Producto> productosVenta() {return new ArrayList<Producto>();}


    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show(HttpSession session, Model model) {
        model.addAttribute("ProductosVenta", new ArrayList<Producto>());
        return "Presentation/Facturar/view";
    }

    @GetMapping ("/presentation/Facturar/FindClient") //Busqueda de cliente para facturar
    public String findUserByID(@RequestParam("nombreC") String id, Model model, HttpSession session){
        model.addAttribute("cliente", service.clienteFindByID(id));
        session.setAttribute("cliente", service.clienteFindByID(id));
        int i=0;
        return "Presentation/Facturar/view";
    }

}
