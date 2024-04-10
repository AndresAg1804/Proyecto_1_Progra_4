package org.example.sistemaproveedores.presentation.Facturar;

import jakarta.servlet.http.HttpSession;
import org.example.sistemaproveedores.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@org.springframework.stereotype.Controller("Facturar")
@SessionAttributes({ "Facturar"})
public class Controller {


    @Autowired
    private Service service;

    @GetMapping("/presentation/Facturar/show")
    public String show(HttpSession session, Model model) {
        //model.addAttribute("ProductosVenta", new ArrayList<Producto>());
        Clientes clienteP=null;
        ArrayList<Detalle> detalleP=null;
        Facturas facturaP=null;
        Usuarios u= (Usuarios) session.getAttribute("usuario");
        Proveedores p= u.getProveedoresByIdprov();

        clienteP=(Clientes)session.getAttribute("cliente");
        if (clienteP==null){
            clienteP=new Clientes();
        }
        session.setAttribute("cliente", clienteP);


        detalleP=(ArrayList<Detalle>)session.getAttribute("DetallesVentaS");
        if(detalleP==null){
            detalleP=new ArrayList<Detalle>();
        }
        session.setAttribute("DetallesVentaS",detalleP);


        facturaP=(Facturas) session.getAttribute("factura");
        if(facturaP==null){
            facturaP=new Facturas();
            facturaP.setProveedoresByIdProveedor(p);
        }
        session.setAttribute("factura", facturaP);

        return "Presentation/Facturar/view";
    }

    @GetMapping ("/presentation/Facturar/FindClient") //Busqueda de cliente para facturar
    public String findUserByID(@RequestParam("nombreC") String id, Model model, HttpSession session){
        //model.addAttribute("cliente", service.clienteFindByID(id));
        Usuarios u= (Usuarios) session.getAttribute("usuario");
        Proveedores p= u.getProveedoresByIdprov();
        Facturas fact= (Facturas) session.getAttribute("factura");

        Clientes cli=service.clienteFindByIDyProvedor(id, p);
        session.setAttribute("cliente", cli);

        fact.setClientesByIdCliente(cli);
        session.setAttribute("factura", fact);

        return "redirect:/presentation/Facturar/show";
    }
    @GetMapping ("/presentation/Facturar/AddProduct")
    public String findProducto(HttpSession session, @RequestParam("idP") String idProducto) {
        Usuarios u = (Usuarios) session.getAttribute("usuario");
        Proveedores p = u.getProveedoresByIdprov();
        ArrayList<Detalle> detalleP = null;
        Detalle nuevo = new Detalle();
        nuevo.setCantidad(1);

            detalleP=(ArrayList<Detalle>)session.getAttribute("DetallesVentaS");
            nuevo.setProductoByIdprod(service.findProdByIdAndProveedor(idProducto,p));
            //nuevo.setMonto(nuevo.getProductoByIdProd().getPrecio() * nuevo.getCantidad()); //Cambiar el monto en la base de datos a un float
        if(detalleP==null){
            detalleP=new ArrayList<Detalle>();
            nuevo.setProductoByIdprod(service.findProdByIdAndProveedor(idProducto,p));
        }
        detalleP.add(nuevo);
        session.setAttribute("DetallesVentaS", detalleP);
        return "redirect:/presentation/Facturar/show";
    }


@GetMapping("/Facturar/EliminateProduct")
    public String deleteProdFromDetalle(HttpSession session, @RequestParam("idProd") String productID){
        ArrayList<Detalle> detalleP=(ArrayList<Detalle>)session.getAttribute("DetallesVentaS");
        detalleP.removeIf(detalle -> detalle.getProductoByIdprod().getIdPr().equals(productID));
        return "redirect:/presentation/Facturar/show";
    }


    public String aumentarCant(HttpSession session, @RequestParam("prod")  String prod){
        ArrayList<Detalle> detalleP=(ArrayList<Detalle>)session.getAttribute("DetallesVentaS");
        Usuarios u = (Usuarios) session.getAttribute("usuario");
        Proveedores p = u.getProveedoresByIdprov();


        return "redirect:/presentation/Facturar/show";
    }
}
