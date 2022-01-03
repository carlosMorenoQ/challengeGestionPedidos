package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.entities.EstadoProcesamiento;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientov;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarEstadoProcesamiento extends Command {

    private final IdProcesamiento idProcesamiento;
    private final EstadoProcesamiento estadoProcesamiento;
    private final EstadoProcesamientov estadoProcesamientov;

    public ModificarEstadoProcesamiento(
            IdProcesamiento idProcesamiento,
            EstadoProcesamiento estadoProcesamiento,
            EstadoProcesamientov estadoProcesamientov) {
        this.idProcesamiento = idProcesamiento;
        this.estadoProcesamiento = estadoProcesamiento;
        this.estadoProcesamientov = estadoProcesamientov;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public EstadoProcesamiento getEstadoProcesamiento() {
        return estadoProcesamiento;
    }

    public EstadoProcesamientov getEstadoProcesamientov() {
        return estadoProcesamientov;
    }
}
