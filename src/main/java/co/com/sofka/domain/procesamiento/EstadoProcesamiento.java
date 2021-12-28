package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generics.Fecha;
import co.com.sofka.domain.procesamiento.values.EstadoProcesamientoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class EstadoProcesamiento extends Entity<EstadoProcesamientoId> {

    private Fecha fecha;
    private EstadoProcesamiento estadoProcesamiento;


    public EstadoProcesamiento(
            EstadoProcesamientoId entityId,
            Fecha fecha,
            EstadoProcesamiento estadoProcesamiento) {
        super(entityId);
        this.fecha = fecha;
        this.estadoProcesamiento = estadoProcesamiento;
    }


    public void modificarEstadoProcesamiento(
            Fecha fecha,
            EstadoProcesamiento estadoProcesamiento){
        this.fecha = fecha;
        this.estadoProcesamiento=estadoProcesamiento;
    }

    public Fecha fecha() {
        return fecha;
    }

    public EstadoProcesamiento estadoProcesamiento() {
        return estadoProcesamiento;
    }

}
