package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.Etapa;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarEtapaEnEtapaDelProcesamientoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdEtapaDelProcesamiento idEtapaDelProcesamiento;
    private final Etapa etapa;

    public ModificarEtapaEnEtapaDelProcesamientoCommand(
            IdProcesamiento idProcesamiento,
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Etapa etapa) {
        this.idProcesamiento = idProcesamiento;
        this.idEtapaDelProcesamiento = idEtapaDelProcesamiento;
        this.etapa = etapa;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

    public IdEtapaDelProcesamiento getIdEtapaDelProcesamiento() {
        return idEtapaDelProcesamiento;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}
