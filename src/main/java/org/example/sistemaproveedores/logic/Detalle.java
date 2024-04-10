package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Detalle {

    @Id
    @Column(name = "numd") // Changed from "numD"
    private int numd;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "monto")
    private Integer monto;
    @ManyToOne
    @JoinColumn(name = "numfact", referencedColumnName = "numfact") // Changed from "numFact"
    private Facturas facturasByNumfact;
    @ManyToOne
    @JoinColumn(name = "idprod", referencedColumnName = "idpr") // Changed from "idProd"
    private Producto productoByIdprod;


    public int getNumd() {
        return numd;
    }

    public void setNumd(int numd) {
        this.numd = numd;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle detalle = (Detalle) o;
        return numd == detalle.numd && Objects.equals(cantidad, detalle.cantidad) && Objects.equals(monto, detalle.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numd, cantidad, monto);
    }

    public Facturas getFacturasByNumfact() {
        return facturasByNumfact;
    }

    public void setFacturasByNumfact(Facturas facturasByNumfact) {
        this.facturasByNumfact = facturasByNumfact;
    }

    public Producto getProductoByIdprod() {
        return productoByIdprod;
    }

    public void setProductoByIdprod(Producto productoByIdprod) {
        this.productoByIdprod = productoByIdprod;
    }

}
