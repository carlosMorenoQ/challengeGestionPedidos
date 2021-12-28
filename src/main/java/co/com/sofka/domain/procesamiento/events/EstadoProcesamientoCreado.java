package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientoId;

public class EstadoProcesamientoCreado extends DomainEvent {

    private final EstadoProcesamientoId estadoProcesamientoId;

    public EstadoProcesamientoCreado(EstadoProcesamientoId estadoProcesamientoId) {
        super("sofka.procesamiento.estadoProcesamientoCreado");
        this.estadoProcesamientoId = estadoProcesamientoId;
    }

    public EstadoProcesamientoId getEstadoProcesamientoId() {
        return estadoProcesamientoId;
    }
}
