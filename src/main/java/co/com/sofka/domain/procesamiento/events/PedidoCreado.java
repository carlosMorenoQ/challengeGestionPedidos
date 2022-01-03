package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.Consecutivo;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.PedidoId;

public class PedidoCreado extends DomainEvent {

    private final PedidoId pedidoId;
    private final Consecutivo consecutivo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public PedidoCreado(
            PedidoId pedidoId,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        super("sofka.procesamiento.pedidoCreado");
        this.pedidoId = pedidoId;
        this.consecutivo = consecutivo;
        this.cliente = cliente;
        this.direccionEntrega= direccionEntrega;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Consecutivo getConsecutivo() {
        return consecutivo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }


}
