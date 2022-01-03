package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class AgregarItemDePedido extends Command {

    private final IdProcesamiento idProcesamiento;
    private final PedidoId pedidoId;
    private final Item item;

    public AgregarItemDePedido(
            IdProcesamiento idProcesamiento,
            PedidoId pedidoId,
            Item item) {
        this.idProcesamiento = idProcesamiento;
        this.pedidoId = pedidoId;
        this.item = item;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Item getItem() {
        return item;
    }
}
