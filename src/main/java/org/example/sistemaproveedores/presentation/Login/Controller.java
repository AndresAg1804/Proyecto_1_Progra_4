package org.example.sistemaproveedores.presentation.Login;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("login")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Login/show")
    public String show() {
        return "Presentation/Login/view";
    }

}
