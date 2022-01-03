package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.values.Procesador;

public class ProcesamientoCreado extends DomainEvent {


    private final Fecha fechaProcesamiento;
    private final Procesador procesador;

    public ProcesamientoCreado(Fecha fechaProcesamiento, Procesador procesador) {
        super("sofka.procesamiento.procesamientocreado");
        this.fechaProcesamiento = fechaProcesamiento;
        this.procesador = procesador;
    }

    public Fecha getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public Procesador getProcesador() {
        return procesador;
    }

}
