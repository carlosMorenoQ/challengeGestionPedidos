package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.Codigo;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;

public class DocumentoDeEntregaCreado extends DomainEvent {

    private final IdDocumentoDeEntrega idDocumentoDeEntrega;
    private final Codigo codigo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;
    private final Fecha fechaCreacion;

    public DocumentoDeEntregaCreado(
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Codigo codigo,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fechaCreacion) {
        super("sofka.transporte.DocumentoDeEntregaCreado");
        this.idDocumentoDeEntrega = idDocumentoDeEntrega;
        this.codigo = codigo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaCreacion = fechaCreacion;
    }

    public IdDocumentoDeEntrega getIdDocumentoDeEntrega() {
        return idDocumentoDeEntrega;
    }

    public Codigo getCodigo() {
        return codigo;
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
