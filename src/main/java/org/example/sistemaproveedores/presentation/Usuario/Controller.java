package org.example.sistemaproveedores.presentation.Usuario;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.example.sistemaproveedores.logic.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller("usuarios")
@SessionAttributes({"usuarios","usuario","a","b"})
//solo el path, como decir un objecto espesifico para poder manerjar este servlet
//agara la info
public class Controller {

    @Autowired
    private Service service;
    @ModelAttribute("usuarios") public Usuarios Usuario() { return new Usuarios(); }

    @GetMapping("/newU")
    public String SENDnewU() {//index->newU
        return "/Presentation/Usuario/newU";
    }
    @GetMapping("/presentation/Usuarios/show")// like mande a otro lado
    public String show(Model model){// index/menu->show all usuarios
        model.addAttribute("S_usuarios", service.usuariosFindAll());
        return "/Presentation/Usuario/view";
    }
    @PostMapping("/Usuarios/newU")//regi y mande a otro lado
    public String registrarUsuario(@RequestParam("usern") String usern,
                                   @RequestParam("pasw") String pasw,
                                   @RequestParam("tipo") String tipo,
                                   @RequestParam("nombreP") String nombreP,
                                   @RequestParam("idP") String idP,
                                   Model model, HttpSession session) {
        Usuarios u=service.addUsuario(usern,pasw,tipo,nombreP,idP);
        return "index";
    }
    @PostMapping("/login/login")
    public String login(@RequestParam("usern") String usern,
                     @RequestParam("pasw") String pasw, HttpSession session) {
        Usuarios u=service.login(usern,pasw);
        if(u!=null){
            session.setAttribute("usuario",u);//Aqui hay que agregar al session el atributo donde esta el proveedor
            switch (u.getTipo()){
                case "PRO":{return "redirect:/presentation/Usuarios/show";}
                case "ADM":{return "redirect:/presentation/Usuarios/amd";}
                default:{return "index";}
            }
        }
        else{
            return "redirect:index";
        }
    }
    @GetMapping("/presentation/Usuarios/amd")
    public String AMDapprove(Model model) {Proveedores u = new Proveedores();
        model.addAttribute("usuarios_too_approve", service.usuariosFindAll());
        return "/Presentation/Usuario/viewALLusuariosAMD";
    }
    @PostMapping("/amd/approve")//regi y mande a otro lado
    public String AMDapprove(@RequestParam("username") String username,
                                   Model model, HttpSession session) {
        service.approvePRO(username);
        return "redirect:/presentation/Usuarios/amd";
    }
}

