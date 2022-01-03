package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;

public class FechaAlistamientoCambiada extends DomainEvent {

    private final Fecha fechaAlistamiento;

    public FechaAlistamientoCambiada(
            Fecha fechaAlistamiento) {
        super("sofka.alistamiento.fechaAlistamientoCambiada");
        this.fechaAlistamiento = fechaAlistamiento;
    }

    public Fecha getFechaAlistamiento() {
        return fechaAlistamiento;
    }

}
