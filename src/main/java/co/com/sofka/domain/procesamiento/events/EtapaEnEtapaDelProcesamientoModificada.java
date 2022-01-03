package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.Etapa;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;

public class EtapaEnEtapaDelProcesamientoModificada extends DomainEvent {

    private final IdEtapaDelProcesamiento idEtapaDelProcesamiento;
    private final Etapa etapa;

    public EtapaEnEtapaDelProcesamientoModificada(
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Etapa etapa) {
        super("sofka.procesamiento.EtapaEnEtapaDelProcesamientoModificada");

        this.idEtapaDelProcesamiento = idEtapaDelProcesamiento;
        this.etapa = etapa;
    }

    public IdEtapaDelProcesamiento getIdEtapaDelProcesamiento() {
        return idEtapaDelProcesamiento;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}
