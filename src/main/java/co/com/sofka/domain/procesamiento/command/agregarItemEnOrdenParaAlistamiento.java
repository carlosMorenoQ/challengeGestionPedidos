package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generics.Item;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class agregarItemEnOrdenParaAlistamiento extends Command {

    private final ProcesamientoId procesamientoId;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Item item;

    public agregarItemEnOrdenParaAlistamiento(
            ProcesamientoId procesamientoId,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Item item) {
        this.procesamientoId = procesamientoId;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.item = item;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Item getItem() {
        return item;
    }
}
