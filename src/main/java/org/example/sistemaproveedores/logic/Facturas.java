package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Facturas {
    @Id
    @Column(name = "numfact")
    private int numfact;
    @Basic
    @Column(name = "total")
    private Integer total;
    @OneToMany(mappedBy = "facturasByNumfact")
    private Collection<Detalle> detallesByNumFact;
    @ManyToOne
    @JoinColumns(@JoinColumn(name = "idcliente", referencedColumnName = "idc"))
    private Clientes clientesByIdCliente;
    @ManyToOne
    @JoinColumns(@JoinColumn(name = "idproveedor", referencedColumnName = "idp"))
    private Proveedores proveedoresByIdProveedor;
    @Basic
    @Column(name = "fecha")
    private String fecha;

    public int getNumFact() {
        return numfact;
    }

    public void setNumFact(int numfact) {
        this.numfact = numfact;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facturas facturas = (Facturas) o;
        return numfact == facturas.numfact && Objects.equals(total, facturas.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numfact, total);
    }

    public Collection<Detalle> getDetallesByNumFact() {
        return detallesByNumFact;
    }

    public void setDetallesByNumFact(Collection<Detalle> detallesByNumFact) {
        this.detallesByNumFact = detallesByNumFact;
    }

    public Clientes getClientesByIdCliente() {
        return clientesByIdCliente;
    }

    public void setClientesByIdCliente(Clientes clientesByIdCliente) {
        this.clientesByIdCliente = clientesByIdCliente;
    }

    public Proveedores getProveedoresByIdProveedor() {
        return proveedoresByIdProveedor;
    }

    public void setProveedoresByIdProveedor(Proveedores proveedoresByIdProveedor) {
        this.proveedoresByIdProveedor = proveedoresByIdProveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumfact() {
        return numfact;
    }

    public void setNumfact(int numfact) {
        this.numfact = numfact;
    }
}
