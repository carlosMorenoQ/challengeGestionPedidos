package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;
import co.com.sofka.domain.procesamiento.values.Procesador;

public class CrearProcesamientoCommand extends Command {


    private final IdProcesamiento idProcesamiento;
    private final Fecha fechaProcesamiento;
    private final Procesador procesador;

    public CrearProcesamientoCommand(
            IdProcesamiento idProcesamiento,
            Fecha fechaProcesamiento,
            Procesador procesador) {
        this.idProcesamiento = idProcesamiento;
        this.fechaProcesamiento = fechaProcesamiento;
        this.procesador = procesador;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

    public Fecha getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public Procesador getProcesador() {
        return procesador;
    }
}
