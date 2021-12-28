package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generics.Item;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.values.PedidoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class AgregarItemDePedido extends Command {

    private final ProcesamientoId procesamientoId;
    private final PedidoId pedidoId;
    private final Item item;

    public AgregarItemDePedido(
            ProcesamientoId procesamientoId,
            PedidoId pedidoId,
            Item item) {
        this.procesamientoId = procesamientoId;
        this.pedidoId = pedidoId;
        this.item = item;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Item getItem() {
        return item;
    }
}
