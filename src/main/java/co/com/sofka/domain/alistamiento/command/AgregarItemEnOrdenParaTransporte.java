package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Item;

public class AgregarItemEnOrdenParaTransporte extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final Item item;

    public AgregarItemEnOrdenParaTransporte(
            IdAlistamiento idAlistamiento,
            IdOrdenParaTransporte idOrdenParaTransporte,
            Item item) {
        this.idAlistamiento = idAlistamiento;
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.item = item;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public Item getItem() {
        return item;
    }

}
