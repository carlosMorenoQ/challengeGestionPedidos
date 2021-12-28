package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generics.Fecha;
import co.com.sofka.domain.generics.Item;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.PedidoId;

import java.util.Set;

public class OrdenParaAlistamientoCreada extends DomainEvent {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final String codigo;
    private final PedidoId pedidoId;
    private Cliente cliente;
    private DireccionEntrega direccionEntrega;
    private final Fecha fecha;

    public OrdenParaAlistamientoCreada(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            String codigo,
            PedidoId pedidoId,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fecha) {
        super("sofka.procesamiento.ordenParaAlistamientoCreada");
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.codigo= codigo;
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fecha = fecha;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
