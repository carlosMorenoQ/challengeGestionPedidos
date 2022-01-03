package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientoId;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientov;

public class EstadoProcesamientoCreado extends DomainEvent {

    private final EstadoProcesamientoId estadoProcesamientoId;
    private final Fecha fecha;
    private final EstadoProcesamientov estadoProcesamientov;

    public EstadoProcesamientoCreado(
            EstadoProcesamientoId estadoProcesamientoId,
            EstadoProcesamientov estadoProcesamientov,
            Fecha fecha) {
        super("sofka.procesamiento.estadoProcesamientoCreado");
        this.estadoProcesamientoId = estadoProcesamientoId;
        this.estadoProcesamientov = estadoProcesamientov;
        this.fecha = fecha;
    }

    public EstadoProcesamientoId getEstadoProcesamientoId() {
        return estadoProcesamientoId;
    }

    public EstadoProcesamientov getEstadoProcesamientov() {
        return estadoProcesamientov;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
