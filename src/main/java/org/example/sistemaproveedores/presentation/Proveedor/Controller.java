package org.example.sistemaproveedores.presentation.Proveedor;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller("Proveedores")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/Proveedor/show")
    public String show() {
        return "Presentation/Proveedores/view";
    }
}
