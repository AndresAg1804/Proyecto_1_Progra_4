package org.example.sistemaproveedores.presentation.clientes;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.sistemaproveedores.logic.Clientes;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@org.springframework.stereotype.Controller("Clientes")
@SessionAttributes({"clientes", "clienteSearch", "clienteEdit","proveedor, mode"})

public class Controller {
    @Autowired
    private Service service;
    @ModelAttribute("clientes") public Iterable<Clientes> clientes() {
        return new ArrayList<Clientes>();
    }

    @ModelAttribute("clienteSearch") public Clientes clienteSearch() {return new Clientes();}

    @ModelAttribute("clienteEdit") public Clientes clienteEdit() {return new Clientes(); }

    @ModelAttribute("proveedor")    public Proveedores proveedor() {return new Proveedores(); }

    @ModelAttribute("mode") public int mode() {return 0; } // 0: add, 1: edit


    @GetMapping("/presentation/Clientes/show")
    public String show(Model model, HttpSession session) {
        Proveedores proveedor = (Proveedores) session.getAttribute("proveedor");
        model.addAttribute("clientes", service.clienteFindByProveedor(proveedor.getIdP()));
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
        session.setAttribute("mode", 1);
        return "redirect:/Presentation/Clientes/show";
    }

    @PostMapping("/presentation/Clientes/save")
    public String save(@ModelAttribute("clienteEdit") @Valid Clientes clienteEdit, BindingResult result, HttpSession session, Model model) {
        int mode = (int) session.getAttribute("mode");
        session.setAttribute("clienteEdit", clienteEdit);
        if (result.hasErrors()) {
            return "/Presentation/Clientes/view";
        }
        Proveedores proveedor = (Proveedores) session.getAttribute("proveedor");
        if (mode == 0) {
            clienteEdit.setProveedoresByProveedorid(proveedor);
            if(service.clienteFindByIDyProvedor(clienteEdit.getIdC(), proveedor) == null) {
                service.addCliente(clienteEdit);
                session.setAttribute("clienteEdit", new Clientes());
                model.addAttribute("clienteEdit", new Clientes());
            }
        }
        else {
            service.clienteEdit(clienteEdit, proveedor);
            session.setAttribute("clienteEdit", new Clientes());
            model.addAttribute("clienteEdit", new Clientes());
            session.setAttribute("mode", 0);
        }
        return "redirect:/Presentation/Clientes/show";
    }


}
