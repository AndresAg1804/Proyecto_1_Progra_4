package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Proveedores {
    @Basic
    @Column(name = "nombrep")
    private String nombrep;

    @Id
    @Column(name = "idp")
    private String idp;
    @Basic
    @Column(name = "aprobado")
    private Byte aprobado;
    @OneToMany(mappedBy = "proveedoresByProveedorid")
    private Collection<Clientes> clientesByIdP;
    @OneToMany(mappedBy = "proveedoresByIdProveedor")
    private Collection<Facturas> facturasByIdP;
    @OneToMany(mappedBy = "proveedoresByIdProd")
    private Collection<Producto> productosByIdP;
    @OneToMany(mappedBy = "proveedoresByIdprov")
    private Collection<Usuarios> usuariosByIdP;


    public String getNombreP() {
        return nombrep;
    }

    public void setNombreP(String nombreP) {
        this.nombrep = nombreP;
    }

    public String getIdP() {
        return idp;
    }

    public void setIdP(String idP) {
        this.idp = idP;
    }

    public Byte getAprobado() {
        return aprobado;
    }

    public void setAprobado(Byte aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedores that = (Proveedores) o;
        return Objects.equals(nombrep, that.nombrep) && Objects.equals(idp, that.idp) && Objects.equals(aprobado, that.aprobado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrep, idp, aprobado);
    }

    public Collection<Clientes> getClientesByIdP() {
        return clientesByIdP;
    }

    public void setClientesByIdP(Collection<Clientes> clientesByIdP) {
        this.clientesByIdP = clientesByIdP;
    }

    public Collection<Facturas> getFacturasByIdP() {
        return facturasByIdP;
    }

    public void setFacturasByIdP(Collection<Facturas> facturasByIdP) {
        this.facturasByIdP = facturasByIdP;
    }

    public Collection<Producto> getProductosByIdP() {
        return productosByIdP;
    }

    public void setProductosByIdP(Collection<Producto> productosByIdP) {
        this.productosByIdP = productosByIdP;
    }

    public Collection<Usuarios> getUsuariosByIdP() {
        return usuariosByIdP;
    }

    public void setUsuariosByIdP(Collection<Usuarios> usuariosByIdP) {
        this.usuariosByIdP = usuariosByIdP;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }
}
