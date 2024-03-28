package org.example.sistemaproveedores.presentation.AcercaDe;
import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@org.springframework.stereotype.Controller("acercaDe")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/AcercaDe/show")
    public String show() {
        return "Presentation/AcercaDe/view";
    }


}
