package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.IdOrdenParaAlistamiento;

public class ItemEnOrdenParaAlistamientoAgregado extends DomainEvent {

    private final IdOrdenParaAlistamiento idOrdenParaAlistamiento;
    private final Item item;

    public ItemEnOrdenParaAlistamientoAgregado(
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            Item item) {
        super("sofka.procesamiento.ItemEnOrdenParaAlistamientoAgregado");

        this.idOrdenParaAlistamiento = idOrdenParaAlistamiento;
        this.item = item;
    }

    public IdOrdenParaAlistamiento getIdOrdenParaAlistamiento() {
        return idOrdenParaAlistamiento;
    }

    public Item getItem() {
        return item;
    }
}
