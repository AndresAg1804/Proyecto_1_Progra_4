package org.example.sistemaproveedores.presentation.clientes;
import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            HttpSession session,
            Model model) {
        Proveedores proveedor = (Proveedores) session.getAttribute("proveedor");
        model.addAttribute("clientes", service.buscarClientesPorNombreYProveedor(clienteSearch.getNombreC(), proveedor));

        return "/Presentation/Clientes/view";
    }

    @GetMapping("/presentation/Clientes/edit")
    public String edit(@RequestParam("idC") String idC, Model model, HttpSession session) {
        Proveedores proveedor = (Proveedores) session.getAttribute("proveedor");
        Clientes cliente = service.clienteFindByIDyProvedor(idC, proveedor);
        model.addAttribute("clienteEdit", cliente);
        session.setAttribute("clienteEdit", cliente);

        return "redirect:/Presentation/Clientes/show";
    }




}
