package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarDireccionEntregaEnOrdenParaAlistamiento extends Command {

    private final IdProcesamiento idProcesamiento;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final DireccionEntrega direccionEntrega;

    public ModificarDireccionEntregaEnOrdenParaAlistamiento(
            IdProcesamiento idProcesamiento,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            DireccionEntrega direccionEntrega) {
        this.idProcesamiento = idProcesamiento;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.direccionEntrega = direccionEntrega;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
