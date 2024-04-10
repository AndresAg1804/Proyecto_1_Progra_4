package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Clientes {
    @Basic
    @Column(name = "nombrec") // Changed from "nombreC"
    private String nombrec;

    @Id
    @Column(name = "idc") // Changed from "idC"
    private String idc;
    @Basic
    @Column(name = "correo")
    private String correo;
    @Basic
    @Column(name = "telefono")
    private Integer telefono;
    @ManyToOne
    @JoinColumn(name = "proveedorid", referencedColumnName = "idp") // Changed from "idP"
    private Proveedores proveedoresByProveedorid;
    @OneToMany(mappedBy = "clientesByIdCliente")
    private Collection<Facturas> facturasByIdc;


    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(nombrec, clientes.nombrec) && Objects.equals(idc, clientes.idc) && Objects.equals(correo, clientes.correo) && Objects.equals(telefono, clientes.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrec, idc, correo, telefono);
    }

    public Proveedores getProveedoresByProveedorid() {
        return proveedoresByProveedorid;
    }

    public void setProveedoresByProveedorid(Proveedores proveedoresByProveedorid) {
        this.proveedoresByProveedorid = proveedoresByProveedorid;
    }

    public Collection<Facturas> getFacturasByIdc() {
        return facturasByIdc;
    }

    public void setFacturasByIdc(Collection<Facturas> facturasByIdc) {
        this.facturasByIdc = facturasByIdc;
    }

}