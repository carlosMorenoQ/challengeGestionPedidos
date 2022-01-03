package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientoId;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientov;

public class CrearEstadoProcesamiento extends Command {

    private final EstadoProcesamientoId estadoProcesamientoId;
    private final Fecha fecha;
    private final EstadoProcesamientov estadoProcesamientov;

    public CrearEstadoProcesamiento(
            EstadoProcesamientoId estadoProcesamientoId,
            Fecha fecha,
            EstadoProcesamientov estadoProcesamientov) {
        this.estadoProcesamientoId = estadoProcesamientoId;
        this.fecha = fecha;
        this.estadoProcesamientov = estadoProcesamientov;
    }

    public EstadoProcesamientoId getEstadoProcesamientoId() {
        return estadoProcesamientoId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public EstadoProcesamientov getEstadoProcesamientov() {
        return estadoProcesamientov;
    }

}
