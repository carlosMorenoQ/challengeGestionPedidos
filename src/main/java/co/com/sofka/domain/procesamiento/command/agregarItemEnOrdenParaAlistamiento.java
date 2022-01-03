package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class agregarItemEnOrdenParaAlistamiento extends Command {

    private final IdProcesamiento idProcesamiento;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Item item;

    public agregarItemEnOrdenParaAlistamiento(
            IdProcesamiento idProcesamiento,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Item item) {
        this.idProcesamiento = idProcesamiento;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.item = item;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Item getItem() {
        return item;
    }
}
