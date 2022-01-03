package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.values.Etapa;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;

public class EtapaDelProcesamientoCreada extends DomainEvent {

    private final IdEtapaDelProcesamiento idEtapaDelProcesamiento;
    private final Fecha fecha;
    private final Etapa etapa;

    public EtapaDelProcesamientoCreada(
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Fecha fecha,
            Etapa etapa) {
        super("sofka.procesamiento.EtapaDelProcesamientoCreada");
        this.idEtapaDelProcesamiento = idEtapaDelProcesamiento;
        this.fecha = fecha;
        this.etapa = etapa;
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
