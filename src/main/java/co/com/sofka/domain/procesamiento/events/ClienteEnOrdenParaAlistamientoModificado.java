package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;

public class ClienteEnOrdenParaAlistamientoModificado extends DomainEvent {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Cliente cliente;

    public ClienteEnOrdenParaAlistamientoModificado(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Cliente cliente) {
        super("sofka.procesamiento.clienteEnOrdenParaAlistamientoModificado");
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.cliente = cliente;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
