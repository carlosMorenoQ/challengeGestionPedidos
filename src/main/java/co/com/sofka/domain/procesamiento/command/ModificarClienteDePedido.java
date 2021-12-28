package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class ModificarClienteDePedido extends Command {

    private final ProcesamientoId procesamientoId;
    private final PedidoId pedidoId;
    private final Cliente cliente;

    public ModificarClienteDePedido(
            ProcesamientoId procesamientoId,
            PedidoId pedidoId,
            Cliente cliente) {
        this.procesamientoId = procesamientoId;
        this.pedidoId = pedidoId;
        this.cliente = cliente;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
