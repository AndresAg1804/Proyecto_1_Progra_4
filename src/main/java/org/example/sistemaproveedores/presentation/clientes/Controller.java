package org.example.sistemaproveedores.presentation.clientes;
import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@org.springframework.stereotype.Controller("Clientes")
@SessionAttributes({"clientes", "clienteSearch", "clienteEdit","proveedor"})

public class Controller {
    @Autowired
    private Service service;
    @ModelAttribute("clientes") public Iterable<Clientes> clientes() {
        return new ArrayList<Clientes>();
    }

    @ModelAttribute("clienteSearch") public Clientes clienteSearch() {return new Clientes();}

    @ModelAttribute("clienteEdit") public Clientes clienteEdit() {return new Clientes(); }

    @ModelAttribute("proveedor")    public Proveedores proveedor() {return new Proveedores(); }




    @GetMapping("/presentation/Clientes/show")
    public String show(Model model) {
        model.addAttribute("clientes", service.clienteFindAll());
        return "/Presentation/Clientes/view";
    }

    @PostMapping("/presentation/Clientes/search")
    public String search(
            @ModelAttribute("clienteSearch") Clientes clienteSearch,
            @ModelAttribute(name="proveedor", binding = false) Proveedores proveedor,
            Model model) {
        model.addAttribute("clientes", service.clienteFindByProveedor(clienteSearch.getProveedoresByProveedorid().getIdP()));
//        model.addAttribute("clientes", service.clienteSearch(proveedor, clienteSearch.getNombreC()));
        model.addAttribute("clienteEdit", new Clientes());
        return "/Presentation/Clientes/view";
    }




}
