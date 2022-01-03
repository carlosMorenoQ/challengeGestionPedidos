package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;

public class EstadoDeEntregaModificado extends DomainEvent {

    private final IdEstadoDeEntrega idEstadoDeEntrega;
    private final Estado estado;

    public EstadoDeEntregaModificado(
            IdEstadoDeEntrega idEstadoDeEntrega,
            Estado estado) {
        super("sofka.transporte.EstadoDeEntregaModificado");
        this.idEstadoDeEntrega = idEstadoDeEntrega;
        this.estado = estado;
    }

    public IdEstadoDeEntrega getIdEstadoDeEntrega() {
        return idEstadoDeEntrega;
    }

    public Estado getEstado() {
        return estado;
    }
}
