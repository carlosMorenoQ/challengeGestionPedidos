package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class ModificarDireccionDePedido extends Command {

    private final ProcesamientoId procesamientoId;
    private final PedidoId pedidoId;
    private final DireccionEntrega direccionEntrega;

    public ModificarDireccionDePedido(
            ProcesamientoId procesamientoId,
            PedidoId pedidoId,
            DireccionEntrega direccionEntrega) {
        this.procesamientoId = procesamientoId;
        this.pedidoId = pedidoId;
        this.direccionEntrega = direccionEntrega;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
