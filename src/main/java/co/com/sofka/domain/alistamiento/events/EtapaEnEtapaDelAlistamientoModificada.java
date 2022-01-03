package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.Etapa;
import co.com.sofka.domain.alistamiento.values.IdEtapaDelAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;

public class EtapaEnEtapaDelAlistamientoModificada extends DomainEvent {

    private final IdEtapaDelAlistamiento idEtapaDelAlistamiento;
    private final Fecha fecha;
    private final Etapa etapa;

    public EtapaEnEtapaDelAlistamientoModificada(
            IdEtapaDelAlistamiento idEtapaDelAlistamiento,
            Fecha fecha,
            Etapa etapa) {
        super("sofka.alistamiento.etapaEnEtapaDelAlistamientoModificada");
        this.idEtapaDelAlistamiento = idEtapaDelAlistamiento;
        this.fecha = fecha;
        this.etapa = etapa;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public IdEtapaDelAlistamiento getIdEtapaDelAlistamiento() {
        return idEtapaDelAlistamiento;
    }

}
