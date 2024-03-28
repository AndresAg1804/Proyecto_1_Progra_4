package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Producto {
    @Basic
    @Column(name = "nombreP")
    private String nombreP;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPr")
    private String idPr;
    @Basic
    @Column(name = "precio")
    private Double precio;
    @OneToMany(mappedBy = "productoByIdProd")
    private Collection<Detalle> detallesByIdPr;

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getIdPr() {
        return idPr;
    }

    public void setIdPr(String idPr) {
        this.idPr = idPr;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombreP, producto.nombreP) && Objects.equals(idPr, producto.idPr) && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreP, idPr, precio);
    }

    public Collection<Detalle> getDetallesByIdPr() {
        return detallesByIdPr;
    }

    public void setDetallesByIdPr(Collection<Detalle> detallesByIdPr) {
        this.detallesByIdPr = detallesByIdPr;
    }
}
