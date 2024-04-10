package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Producto {
    @Basic
    @Column(name = "nombrep")
    private String nombrep;

    @Id
    @Column(name = "idpr")
    private String idpr;
    @Basic
    @Column(name = "precio")
    private Double precio;
    @Basic
    @Column(name = "cant")
    private Integer cant;
    @OneToMany(mappedBy = "productoByIdprod")
    private Collection<Detalle> detallesByIdPr;
    @ManyToOne
    @JoinColumn(name = "idprod", referencedColumnName = "idp")
    private Proveedores proveedoresByIdProd;

    //@Id                     Esto da errores
    //@Column(name = "idprod")
    //private String idprod;

    public Producto(String idPr, String nombreP,Double precio,Integer cant) {
        this.idpr = idPr;
        this.nombrep=nombreP;
        this.precio=precio;
        this.cant=cant;
    }

    public Producto() {
        this.idpr = "";
        this.nombrep="";
        this.precio=0.0;
        this.cant=0;
    }

    public String getNombreP() {
        return nombrep;
    }

    public void setNombreP(String nombreP) {
        this.nombrep = nombreP;
    }

    public String getIdPr() {
        return idpr;
    }

    public void setIdPr(String idPr) {
        this.idpr = idPr;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombrep, producto.nombrep) && Objects.equals(idpr, producto.idpr) && Objects.equals(precio, producto.precio) && Objects.equals(cant, producto.cant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrep, idpr, precio, cant);
    }

    public Collection<Detalle> getDetallesByIdPr() {
        return detallesByIdPr;
    }

    public void setDetallesByIdPr(Collection<Detalle> detallesByIdPr) {
        this.detallesByIdPr = detallesByIdPr;
    }

    public Proveedores getProveedoresByIdProd() {
        return proveedoresByIdProd;
    }

    public void setProveedoresByIdProd(Proveedores proveedoresByIdProd) {
        this.proveedoresByIdProd = proveedoresByIdProd;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getIdpr() {
        return idpr;
    }

    public void setIdpr(String idpr) {
        this.idpr = idpr;
    }


}
