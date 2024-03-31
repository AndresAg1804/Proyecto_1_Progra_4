package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Detalle {
    @Id
    @Column(name = "numD")
    private int numD;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "numFact", referencedColumnName = "numFact")
    private Facturas facturasByNumFact;
    @ManyToOne
    @JoinColumn(name = "idProd", referencedColumnName = "idPr")
    private Producto productoByIdProd;

    public int getNumD() {
        return numD;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle detalle = (Detalle) o;
        return numD == detalle.numD && Objects.equals(cantidad, detalle.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numD, cantidad);
    }

    public Facturas getFacturasByNumFact() {
        return facturasByNumFact;
    }

    public void setFacturasByNumFact(Facturas facturasByNumFact) {
        this.facturasByNumFact = facturasByNumFact;
    }

    public Producto getProductoByIdProd() {
        return productoByIdProd;
    }

    public void setProductoByIdProd(Producto productoByIdProd) {
        this.productoByIdProd = productoByIdProd;
    }
}
