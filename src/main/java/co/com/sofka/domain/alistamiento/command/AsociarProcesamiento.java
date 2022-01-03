package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class AsociarProcesamiento extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdProcesamiento idProcesamiento;

    public AsociarProcesamiento(
            IdAlistamiento idAlistamiento,
            IdProcesamiento idProcesamiento) {
        this.idAlistamiento = idAlistamiento;
        this.idProcesamiento = idProcesamiento;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }
}
