package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Fecha;

public class AgregarEtapaDelAlistamiento extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdEtapaDelAlistamiento idEtapaDelAlistamiento;
    private final Fecha fechaEtapa;
    private final Etapa etapa;

    public AgregarEtapaDelAlistamiento(
            IdAlistamiento idAlistamiento,
            IdEtapaDelAlistamiento idEtapaDelAlistamiento,
            Fecha fechaEtapa,
            Etapa etapa) {
        this.idAlistamiento = idAlistamiento;
        this.idEtapaDelAlistamiento = idEtapaDelAlistamiento;
        this.fechaEtapa = fechaEtapa;
        this.etapa = etapa;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdEtapaDelAlistamiento getIdEtapaDelAlistamiento() {
        return idEtapaDelAlistamiento;
    }

    public Fecha getFechaEtapa() {
        return fechaEtapa;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}
