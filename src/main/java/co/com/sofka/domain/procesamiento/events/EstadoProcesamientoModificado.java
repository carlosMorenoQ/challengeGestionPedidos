package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientov;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientoId;

public class EstadoProcesamientoModificado extends DomainEvent {

    private final EstadoProcesamientoId estadoProcesamientoId;
    private final EstadoProcesamientov estadoProcesamientov;

    public EstadoProcesamientoModificado(
            EstadoProcesamientoId estadoProcesamientoId,
            EstadoProcesamientov estadoProcesamientov) {
        super("sofka.procesamiento.estadoProcesamientoModificado");
        this.estadoProcesamientoId = estadoProcesamientoId;
        this.estadoProcesamientov = estadoProcesamientov;
    }

    public EstadoProcesamientoId getEstadoProcesamientoId() {
        return estadoProcesamientoId;
    }

    public EstadoProcesamientov getEstadoProcesamientov() {
        return estadoProcesamientov;
    }
}
