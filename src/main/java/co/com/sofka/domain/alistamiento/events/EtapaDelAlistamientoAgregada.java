package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.Etapa;
import co.com.sofka.domain.alistamiento.values.IdEtapaDelAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;

public class EtapaDelAlistamientoAgregada extends DomainEvent {

    private final IdEtapaDelAlistamiento entityId;
    private final Fecha fechaEtapa;
    private final Etapa etapa;

    public EtapaDelAlistamientoAgregada(
            IdEtapaDelAlistamiento entityId,
            Fecha fechaEtapa,
            Etapa etapa) {
        super("sofka.alistamiento.etapaDelAlistamientoAgregada");
        this.entityId = entityId;
        this.fechaEtapa = fechaEtapa;
        this.etapa = etapa;
    }

    public IdEtapaDelAlistamiento getEntityId() {
        return entityId;
    }

    public Fecha getFechaEtapa() {
        return fechaEtapa;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}
