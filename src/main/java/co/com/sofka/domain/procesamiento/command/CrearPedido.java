package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.*;

public class CrearPedido extends Command {


    private final ProcesamientoId procesamientoId;
    private final PedidoId pedidoId;
    private final Consecutivo consecutivo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public CrearPedido(
            ProcesamientoId procesamientoId,
            PedidoId pedidoId,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        this.procesamientoId = procesamientoId;
        this.pedidoId = pedidoId;
        this.consecutivo = consecutivo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
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
