package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;

public class OrdenParaAlistamientoCreada extends DomainEvent {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;

    public OrdenParaAlistamientoCreada(OrdenParaAlistamientoId ordenParaAlistamientoId) {
        super("sofka.procesamiento.ordenParaAlistamientoCreada");
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }
}
