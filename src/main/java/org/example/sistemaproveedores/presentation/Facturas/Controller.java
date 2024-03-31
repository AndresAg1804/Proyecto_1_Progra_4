package org.example.sistemaproveedores.presentation.Facturas;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.Facturas;
import org.example.sistemaproveedores.logic.Proveedores;
import org.example.sistemaproveedores.logic.Service;
import org.example.sistemaproveedores.logic.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"Sfacturas"})
@org.springframework.stereotype.Controller("Factura")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturas/show")
    public String show(Model model, HttpSession session) {
        Usuarios u= (Usuarios) session.getAttribute("usuario");
        Proveedores p= u.getProveedoresByIdprov();
        Iterable<Facturas> f=service.findFacturasByIdProveedor(p);
        model.addAttribute("Sfacturas", f);
        return "/Presentation/Facturas/view";
    }

}
