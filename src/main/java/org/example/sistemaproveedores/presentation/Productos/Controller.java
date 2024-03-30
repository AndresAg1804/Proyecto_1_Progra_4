package org.example.sistemaproveedores.presentation.Productos;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("Productos")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Productos/view")
    public String show(Model model) {
        model.addAttribute("productos", service.proveedorFindAll());
        return "/Presentation/Productos/view";
    }

}
