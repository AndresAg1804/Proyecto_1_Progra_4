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
    public String editarPRO(@RequestParam("idpr")String idpr,
                            @RequestParam("nombrep")String nombrep,
                            @RequestParam("precio")Double precio,
                            @RequestParam("cant")Integer cant,
                            Model model, HttpSession session){


        Producto p=new Producto(idpr,nombrep,precio,cant);
        session.setAttribute("proEDIT", p);
        model.addAttribute("proEDIT",p);
        return "redirect:/presentation/Productos/show";
    }
    @PostMapping("/productos/add")
    public String appPRO(@RequestParam("idpr") String idpr,
                         @RequestParam("nombrep") String nombrep,
                         @RequestParam("precio") Double precio,
                         @RequestParam("cant")Integer cant,
                         Model model, HttpSession session){
        Producto producto=new Producto(idpr,nombrep,precio,cant);

        Usuarios u=(Usuarios) session.getAttribute("usuario");
        Proveedores prove =u.getProveedoresByIdprov();
        producto.setProveedoresByIdProd(service.get_ProvedorBYID(u.getUsern()));

        if(model.getAttribute("proEDIT")!=null){
            service.updateProducto( nombrep,  precio,  cant, idpr);
            session.setAttribute("proEDIT", null);
            model.addAttribute("proEDIT", null);
        }
        else {
            //porque el ID DE cada Provedor es el Username
            service.addProdcuto(producto);
            session.setAttribute("proEDIT", null);
            model.addAttribute("proEDIT", null);
        }
        return "redirect:/presentation/Productos/show";
    }

}
