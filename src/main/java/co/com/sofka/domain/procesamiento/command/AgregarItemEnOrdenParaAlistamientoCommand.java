package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.procesamiento.values.IdOrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class AgregarItemEnOrdenParaAlistamientoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdOrdenParaAlistamiento idOrdenParaAlistamiento;
    private final Item item;

    public AgregarItemEnOrdenParaAlistamientoCommand(
            IdProcesamiento idProcesamiento,
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            Item item) {
        this.idProcesamiento = idProcesamiento;
        this.idOrdenParaAlistamiento = idOrdenParaAlistamiento;
        this.item = item;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

    public IdOrdenParaAlistamiento getIdOrdenParaAlistamiento() {
        return idOrdenParaAlistamiento;
    }

    public Item getItem() {
        return item;
    }
}
