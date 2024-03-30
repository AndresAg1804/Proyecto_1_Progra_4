package org.example.sistemaproveedores.presentation.Usuario;

import jakarta.servlet.http.HttpSession;
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
    @GetMapping("/presentation/Usuarios/show")
    public String show(Model model){// index/menu->show all usuarios
        model.addAttribute("S_usuarios", service.usuariosFindAll());
        return "/presentation/Usuarios/view";
    }
    @PostMapping("/Usuarios/newU")
    public String registrarUsuario(@RequestParam("usern") String usern,
                                   @RequestParam("pasw") String pasw,
                                   @RequestParam("tipo") String tipo,
                                   Model model) {
        service.addUsuario(usern,pasw,tipo);
        return "index";
    }
    @PostMapping("/login/login")
    public String login(@RequestParam("usern") String usern,
                     @RequestParam("pasw") String pasw, HttpSession session) {
        Usuarios u=service.login(usern,pasw);
        if(u!=null){
            session.setAttribute("usuario",u);
            switch (u.getTipo()){
                case "PRO":{return "redirect: /presentation/Facturar/show";}
                case "ADM":{return "redirect: /presentation/Facturar/show";}
                default:{return "index";}
            }
        }
        else{
            return "redirect: index";
        }
    }
}

