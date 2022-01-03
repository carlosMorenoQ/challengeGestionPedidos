package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.procesamiento.values.IdPedido;

public class ItemEnPedidoAgregado extends DomainEvent {


    private final IdPedido idPedido;
    private final Item item;

    public ItemEnPedidoAgregado(
            IdPedido idPedido,
            Item item) {
        super("sofka.procesamiento.itemenpedidoagregado");
        this.idPedido = idPedido;
        this.item = item;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Item getItem() {
        return item;
    }
}
