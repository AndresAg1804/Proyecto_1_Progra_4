package org.example.sistemaproveedores.presentation.Productos;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Producto;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.example.sistemaproveedores.logic.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller("Productos")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Productos/show")
    public String show(Model model,HttpSession session) {

        if(session.getAttribute("proEDIT")!=null){
            Producto proEDIT = (Producto) session.getAttribute("proEDIT");
            if(proEDIT.getNombreP()!=""){
                model.addAttribute("proEDIT", proEDIT);
            }
            else{
                model.addAttribute("proEDIT", null);
            }
        }
        //existe una mejor manera? si
        Usuarios u=(Usuarios) session.getAttribute("usuario");
        model.addAttribute("productos",service.get_all_productos_de_IDprovedor(u.getProveedoresByIdprov().getIdP()));

        return "/Presentation/Productos/view";
    }
    @GetMapping("/set/editpro") //por mas que modifique los <a> solo pueden ser GetMapping
    public String editarPRO(@RequestParam("idPr")String idPr,
                            @RequestParam("nombreP")String nombreP,
                            @RequestParam("precio")Double precio,
                            @RequestParam("cant")Integer cant,
                            Model model, HttpSession session){

        //Hotel h=(Hotel)model.getAttribute("hotel");
        //Hotel hdos=service.findById(h.getId());
        //metodos de service para hacer el update

        Producto pp=new Producto(idPr,nombreP,precio,cant);
        session.setAttribute("proEDIT", pp);
        model.addAttribute("proEDIT",pp);
        return "redirect:/presentation/Productos/show";
    }
    @PostMapping("/productos/add")
    public String appPRO(@RequestParam("idPr") String idPr,
                         @RequestParam("nombreP") String nombreP,
                         @RequestParam("precio") Double precio,
                         @RequestParam("cant")Integer cant,
                         Model model, HttpSession session){
        Producto p=new Producto(idPr,nombreP,precio,cant);
        Usuarios u=(Usuarios) session.getAttribute("usuario");

        p.setProveedoresByIdProd(service.get_ProvedorBYID(u.getUsern()));
        service.addProdcuto(p);
        session.setAttribute("proEDIT", null);
        model.addAttribute("proEDIT",null);
        return "redirect:/presentation/Productos/show";
    }

}
