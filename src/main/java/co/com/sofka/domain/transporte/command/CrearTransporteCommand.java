package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;
import co.com.sofka.domain.transporte.values.IdTransporte;

public class CrearTransporteCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdAlistamiento idAlistamiento;
    private final Fecha fechaTransporte;

    public CrearTransporteCommand(
            IdTransporte idTransporte,
            IdAlistamiento idAlistamiento,
            Fecha fechaTransporte) {
        this.idTransporte = idTransporte;
        this.idAlistamiento = idAlistamiento;
        this.fechaTransporte = fechaTransporte;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public Fecha getFechaTransporte() {
        return fechaTransporte;
    }
}
