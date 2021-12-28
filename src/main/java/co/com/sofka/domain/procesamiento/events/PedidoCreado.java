package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.PedidoId;

public class PedidoCreado extends DomainEvent {

    private PedidoId pedidoId;

    public PedidoCreado(String type, PedidoId pedidoId) {
        super("sofka.procesamiento.pedidoCreado");
        this.pedidoId = pedidoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
