package org.example.sistemaproveedores.presentation.Usuario;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("Usuario")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Usuario/show")
    public String show() {
        return "Presentation/Usuario/view";
    }

}

