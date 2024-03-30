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
    public String shownewU() {
        return "Presentation/Usuario/newU";
    }

    @GetMapping("/presentation/Usuario/show")
    public String show() {
        return "Presentation/Usuario/view";
    }
    //esto es para poder redireccionar al usuario a otra pagina HTML
    @PostMapping("/Usuarios/newU")
    public String registrarUsuario(@RequestParam("usern") String usern,
                                   @RequestParam("pasw") String pasw,
                                   @RequestParam("tipo") String tipo,
                                   Model model) {
        service.addUsuario(usern,pasw,tipo);
        return "index";
    }
}

