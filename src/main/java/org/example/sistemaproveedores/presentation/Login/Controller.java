package org.example.sistemaproveedores.presentation.Login;
import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller("login")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Login/show")
    public String show(Model model,HttpSession session) {
        return "Presentation/Login/view";
    }

}
