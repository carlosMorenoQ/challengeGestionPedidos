package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;

public class EstadoEntregaCreado extends DomainEvent {

    private final IdEstadoDeEntrega idEstadoDeEntrega;
    private final Fecha fechaEstado;
    private final Estado estado;

    public EstadoEntregaCreado(
            IdEstadoDeEntrega idEstadoDeEntrega,
            Fecha fechaEstado,
            Estado estado) {
        super("sofka.transporte.EstadoEntregaCreado");
        this.idEstadoDeEntrega = idEstadoDeEntrega;
        this.fechaEstado = fechaEstado;
        this.estado = estado;
    }

    public IdEstadoDeEntrega getIdEstadoDeEntrega() {
        return idEstadoDeEntrega;
    }

    public Fecha getFechaEstado() {
        return fechaEstado;
    }

    public Estado getEstado() {
        return estado;
    }
}
