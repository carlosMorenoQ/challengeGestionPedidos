package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Item;

public class ItemEnOrdenParaTransporteAgregado extends DomainEvent {

    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final Item item;

    public ItemEnOrdenParaTransporteAgregado(
            IdOrdenParaTransporte idOrdenParaTransporte,
            Item item) {
        super("sofka.alistamiento.itemEnOrdenParaTransporteAgregado");
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.item = item;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public Item getItem() {
        return item;
    }
}
