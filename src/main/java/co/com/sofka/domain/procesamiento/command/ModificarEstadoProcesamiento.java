package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.EstadoProcesamiento;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientov;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class ModificarEstadoProcesamiento extends Command {

    private final ProcesamientoId procesamientoId;
    private final EstadoProcesamiento estadoProcesamiento;
    private final EstadoProcesamientov estadoProcesamientov;

    public ModificarEstadoProcesamiento(
            ProcesamientoId procesamientoId,
            EstadoProcesamiento estadoProcesamiento,
            EstadoProcesamientov estadoProcesamientov) {
        this.procesamientoId = procesamientoId;
        this.estadoProcesamiento = estadoProcesamiento;
        this.estadoProcesamientov = estadoProcesamientov;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public EstadoProcesamiento getEstadoProcesamiento() {
        return estadoProcesamiento;
    }

    public EstadoProcesamientov getEstadoProcesamientov() {
        return estadoProcesamientov;
    }
}
