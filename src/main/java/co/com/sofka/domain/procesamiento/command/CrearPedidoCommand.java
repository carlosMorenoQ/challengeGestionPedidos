package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.*;

public class CrearPedidoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdPedido idPedido;
    private final Consecutivo consecutivo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public CrearPedidoCommand(
            IdProcesamiento idProcesamiento,
            IdPedido idPedido,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        this.idProcesamiento = idProcesamiento;
        this.idPedido = idPedido;
        this.consecutivo = consecutivo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
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
