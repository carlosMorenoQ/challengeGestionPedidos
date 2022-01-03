package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;

public class ItemEnDocumentoDeEntregaAgregado extends DomainEvent {

    private final IdDocumentoDeEntrega idDocumentoDeEntrega;
    private final Item item;

    public ItemEnDocumentoDeEntregaAgregado(
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Item item) {
        super("sofka.");
        this.idDocumentoDeEntrega = idDocumentoDeEntrega;
        this.item = item;
    }

    public IdDocumentoDeEntrega getIdDocumentoDeEntrega() {
        return idDocumentoDeEntrega;
    }

    public Item getItem() {
        return item;
    }
}
