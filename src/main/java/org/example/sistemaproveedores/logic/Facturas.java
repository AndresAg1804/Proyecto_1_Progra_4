package org.example.sistemaproveedores.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Facturas {

    @Id
    @Column(name = "numFact")
    private int numFact;
    @OneToMany(mappedBy = "facturasByNumFact")
    private Collection<Detalle> detallesByNumFact;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idC")
    private Clientes clientesByIdCliente;
    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idP")
    private Proveedores proveedoresByIdProveedor;

    public int getNumFact() {
        return numFact;
    }

    public void setNumFact(int numFact) {
        this.numFact = numFact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facturas facturas = (Facturas) o;
        return numFact == facturas.numFact;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFact);
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
}
