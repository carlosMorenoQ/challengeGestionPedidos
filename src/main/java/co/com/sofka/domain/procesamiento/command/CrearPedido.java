package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.*;

public class CrearPedido extends Command {


    private final IdProcesamiento idProcesamiento;
    private final PedidoId pedidoId;
    private final Consecutivo consecutivo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public CrearPedido(
            IdProcesamiento idProcesamiento,
            PedidoId pedidoId,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        this.idProcesamiento = idProcesamiento;
        this.pedidoId = pedidoId;
        this.consecutivo = consecutivo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
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
