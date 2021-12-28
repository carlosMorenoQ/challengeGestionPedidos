package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.PedidoId;


public class ClienteDePedidoModificado extends DomainEvent {

    private final PedidoId pedidoId;
    private final Cliente cliente;

    public ClienteDePedidoModificado(PedidoId pedidoId, Cliente cliente) {
        super("sofka.procesamiento.clienteDePedidoModificado");
        this.cliente = cliente;
        this.pedidoId = pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

}
