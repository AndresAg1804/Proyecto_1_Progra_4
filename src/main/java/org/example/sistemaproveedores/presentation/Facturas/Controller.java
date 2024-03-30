package org.example.sistemaproveedores.presentation.Facturas;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("Facturas")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturas/show")
    public String show(Model model) {
        model.addAttribute("facturas", service.facturasFindAll());
        return "/Presentation/Facturas/view";
    }

}
