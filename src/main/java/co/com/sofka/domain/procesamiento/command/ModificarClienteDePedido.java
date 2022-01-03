package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarClienteDePedido extends Command {

    private final IdProcesamiento idProcesamiento;
    private final PedidoId pedidoId;
    private final Cliente cliente;

    public ModificarClienteDePedido(
            IdProcesamiento idProcesamiento,
            PedidoId pedidoId,
            Cliente cliente) {
        this.idProcesamiento = idProcesamiento;
        this.pedidoId = pedidoId;
        this.cliente = cliente;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
