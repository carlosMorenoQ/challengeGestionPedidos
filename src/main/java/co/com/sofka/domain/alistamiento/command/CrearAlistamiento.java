package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Fecha;

public class CrearAlistamiento extends Command {


    private final IdAlistamiento idAlistamiento;
    private final Fecha fechaAlistamiento;

    public CrearAlistamiento(
            IdAlistamiento idAlistamiento,
            Fecha fechaAlistamiento) {
        this.idAlistamiento = idAlistamiento;
        this.fechaAlistamiento = fechaAlistamiento;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public Fecha getFechaAlistamiento() {
        return fechaAlistamiento;
    }
}
