package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generics.Fecha;

public class Alistamiento extends AggregateEvent<IdAlistamiento> {

    protected OrdenParaTransporte ordenParaTransporte;
    protected Bodega bodega;
    protected EstadoAlistamiento estadoAlistamiento;
    protected Fecha fecha;

    public Alistamiento(
            IdAlistamiento entityId,
            OrdenParaTransporte ordenParaTransporte,
            Bodega bodega,
            EstadoAlistamiento estadoAlistamiento,
            Fecha fecha) {
        super(entityId);
        this.ordenParaTransporte = ordenParaTransporte;
        this.bodega = bodega;
        this.estadoAlistamiento = estadoAlistamiento;
        this.fecha = fecha;
    }

    public OrdenParaTransporte OrdenParaTransporte() {
        return ordenParaTransporte;
    }

    public Bodega bodega() {
        return bodega;
    }

    public EstadoAlistamiento estadoAlistamiento() {
        return estadoAlistamiento;
    }

    public Fecha fecha() {
        return fecha;
    }
}
