package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;
import co.com.sofka.domain.transporte.values.IdTransporte;

public class AgregarItemEnDocumentoDeEntregaCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdDocumentoDeEntrega idDocumentoDeEntrega;
    private final Item item;

    public AgregarItemEnDocumentoDeEntregaCommand(
            IdTransporte idTransporte,
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Item item) {
        this.idTransporte = idTransporte;
        this.idDocumentoDeEntrega = idDocumentoDeEntrega;
        this.item = item;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdDocumentoDeEntrega getIdDocumentoDeEntrega() {
        return idDocumentoDeEntrega;
    }

    public Item getItem() {
        return item;
    }
}
