package co.com.sofka.domain.transporte.entities;

import co.com.sofka.domain.genericvalues.*;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;

import java.util.HashSet;
import java.util.Set;

public class DocumentoDeEntrega extends Entity<IdDocumentoDeEntrega> {

    private final Codigo codigo;
    private final Set<Item> items;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;
    private final Fecha fechaCreacion;

    public DocumentoDeEntrega(
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Codigo codigo,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fechaCreacion) {
        super(idDocumentoDeEntrega);
        this.codigo = codigo;
        this.items = new HashSet<>();
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarItem(Item item){
        this.items.add(item);
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }
}
