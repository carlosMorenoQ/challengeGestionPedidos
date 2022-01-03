package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.values.Etapa;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class CrearEtapaDelProcesamientoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdEtapaDelProcesamiento idEtapaDelProcesamiento;
    private final Fecha fecha;
    private final Etapa etapa;

    public CrearEtapaDelProcesamientoCommand(
            IdProcesamiento idProcesamiento,
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Fecha fecha,
            Etapa etapa) {
        this.idProcesamiento = idProcesamiento;
        this.idEtapaDelProcesamiento = idEtapaDelProcesamiento;
        this.fecha = fecha;
        this.etapa = etapa;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

    public IdEtapaDelProcesamiento getIdEtapaDelProcesamiento() {
        return idEtapaDelProcesamiento;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}
