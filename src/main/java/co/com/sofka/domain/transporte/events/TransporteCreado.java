package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;

public class TransporteCreado extends DomainEvent {

    private final IdAlistamiento idAlistamiento;
    private final Fecha fechaTransporte;

    public TransporteCreado(
            IdAlistamiento idAlistamiento,
            Fecha fechaTransporte) {
        super("sofka.transporte.Transporte");
        this.idAlistamiento = idAlistamiento;
        this.fechaTransporte = fechaTransporte;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public Fecha getFechaTransporte() {
        return fechaTransporte;
    }

}
