package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.PedidoId;

public class DireccionDePedidoModificada extends DomainEvent {

    private final PedidoId pedidoId;
    private final DireccionEntrega direccionEntrega;

    public DireccionDePedidoModificada(
            PedidoId pedidoId,
            DireccionEntrega direccionEntrega) {
        super("sofka.procesamiento.direccionDePedidoModificada");
        this.pedidoId = pedidoId;
        this.direccionEntrega = direccionEntrega;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
