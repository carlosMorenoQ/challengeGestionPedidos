package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ProcesamientoAsociado extends DomainEvent {

    private final IdProcesamiento idProcesamiento;


    public ProcesamientoAsociado(IdProcesamiento idProcesamiento) {
        super("sofka.alistamiento.procesamientoAsociado");
        this.idProcesamiento = idProcesamiento;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

}
