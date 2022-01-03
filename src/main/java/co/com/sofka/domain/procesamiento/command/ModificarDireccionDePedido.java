package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarDireccionDePedido extends Command {

    private final IdProcesamiento idProcesamiento;
    private final PedidoId pedidoId;
    private final DireccionEntrega direccionEntrega;

    public ModificarDireccionDePedido(
            IdProcesamiento idProcesamiento,
            PedidoId pedidoId,
            DireccionEntrega direccionEntrega) {
        this.idProcesamiento = idProcesamiento;
        this.pedidoId = pedidoId;
        this.direccionEntrega = direccionEntrega;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
