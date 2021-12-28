package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.values.EstadoAlistamientoValue;
import co.com.sofka.domain.alistamiento.values.IdEstadoAlistamiento;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generics.Fecha;

public class EstadoAlistamiento extends Entity<IdEstadoAlistamiento> {

    private final Fecha fecha;
    private final EstadoAlistamientoValue estadoAlistamientoValue;

    public EstadoAlistamiento(
            IdEstadoAlistamiento entityId,
            Fecha fecha,
            EstadoAlistamientoValue estadoAlistamientoValue) {
        super(entityId);
        this.fecha = fecha;
        this.estadoAlistamientoValue = estadoAlistamientoValue;
    }

    public Fecha fecha() {
        return fecha;
    }

    public EstadoAlistamientoValue estadoAlistamientoValue() {
        return estadoAlistamientoValue;
    }


}
