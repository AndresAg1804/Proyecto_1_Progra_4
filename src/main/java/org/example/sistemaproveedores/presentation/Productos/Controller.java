package org.example.sistemaproveedores.presentation.Productos;

import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("Productos")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Productos/show")
    public String show() {
        return "/Presentation/Productos/view";
    }

}
