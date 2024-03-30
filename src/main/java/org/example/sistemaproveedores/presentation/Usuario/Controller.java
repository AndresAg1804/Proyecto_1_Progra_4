package org.example.sistemaproveedores.presentation.Usuario;

import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.example.sistemaproveedores.logic.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller("usuarios")
@SessionAttributes({"usuarios"})
public class Controller {

    @Autowired
    private Service service;
    @ModelAttribute("usuarios") public Usuarios Usuario() {return new Usuarios(); }
    @GetMapping("/newU")
    public String SENDnewU() {//index->newU
        return "/Presentation/Usuario/newU";
    }

    @GetMapping("/presentatio/Usuarios/view")
    public String show(Model model){// index/menu->show all usuarios
        model.addAttribute("S_usuarios", service.usuariosFindAll());
        return "/Presentation/Usuario/viewU";
    }
    @PostMapping("/Usuarios/newU")
    public String registrarUsuario(@RequestParam("usern") String usern,
                                   @RequestParam("pasw") String pasw,
                                   @RequestParam("tipo") String tipo,
                                   Model model) {
        service.addUsuario(usern,pasw,tipo);
        return "index";
    }
}

