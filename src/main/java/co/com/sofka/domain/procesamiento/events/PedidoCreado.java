package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.Consecutivo;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.IdPedido;

public class PedidoCreado extends DomainEvent {


    private final IdPedido idPedido;
    private final Consecutivo consecutivo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public PedidoCreado(
            IdPedido idPedido,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        super("sofka.procesamiento.pedidocreado");
        this.idPedido = idPedido;
        this.consecutivo = consecutivo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public IdPedido getIdPedido() {
        return idPedido;
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
