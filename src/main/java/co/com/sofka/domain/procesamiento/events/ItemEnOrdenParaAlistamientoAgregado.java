package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;

public class ItemEnOrdenParaAlistamientoAgregado extends DomainEvent {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Item item;

    public ItemEnOrdenParaAlistamientoAgregado(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Item item) {
        super("sofka.procedimiento.itemEnOrdenParaAlistamientoAgregado");
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.item = item;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Item getItem() {
        return item;
    }
}
