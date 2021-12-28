package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;

public class DireccionEntregaEnOrdenParaAlistamientoModificada extends DomainEvent {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final DireccionEntrega direccionEntrega;

    public DireccionEntregaEnOrdenParaAlistamientoModificada(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            DireccionEntrega direccionEntrega) {
        super("sofka.procesamiento.direccionEntregaEnOrdenParaAlistamientoModificada");
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.direccionEntrega = direccionEntrega;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

}
