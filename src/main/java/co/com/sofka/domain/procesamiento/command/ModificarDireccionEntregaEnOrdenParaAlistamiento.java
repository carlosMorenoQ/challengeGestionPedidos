package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class ModificarDireccionEntregaEnOrdenParaAlistamiento extends Command {

    private final ProcesamientoId procesamientoId;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final DireccionEntrega direccionEntrega;

    public ModificarDireccionEntregaEnOrdenParaAlistamiento(
            ProcesamientoId procesamientoId,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            DireccionEntrega direccionEntrega) {
        this.procesamientoId = procesamientoId;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.direccionEntrega = direccionEntrega;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
