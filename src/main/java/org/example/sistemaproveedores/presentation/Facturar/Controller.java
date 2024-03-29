package org.example.sistemaproveedores.presentation.Facturar;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("Facturar")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show() {
        return "Presentation/Facturar/view";
    }

}
