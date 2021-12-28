package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generics.Item;
import co.com.sofka.domain.procesamiento.values.PedidoId;

public class ItemDePedidoAgregado extends DomainEvent {

    private final PedidoId pedidoId;
    private final Item item;

    public ItemDePedidoAgregado(
            PedidoId pedidoId,
            Item item) {
        super("sofka.procedimiento.itemDePedidoAgregado");
        this.pedidoId = pedidoId;
        this.item = item;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Item getItem() {
        return item;
    }
}
