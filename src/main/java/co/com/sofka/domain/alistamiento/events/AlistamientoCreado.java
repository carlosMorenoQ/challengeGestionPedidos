package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;

public class AlistamientoCreado extends DomainEvent {

    private final Fecha fechaAlistamiento;

    public AlistamientoCreado(
            Fecha fechaAlistamiento) {
        super("sofka.alistamiento.alistamientocreado");
        this.fechaAlistamiento = fechaAlistamiento;
    }

    public Fecha getFechaAlistamiento() {
        return fechaAlistamiento;
    }
}
