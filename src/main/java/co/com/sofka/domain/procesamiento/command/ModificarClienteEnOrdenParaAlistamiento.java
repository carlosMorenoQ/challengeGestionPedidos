package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.ProcesamientoId;

public class ModificarClienteEnOrdenParaAlistamiento extends Command {

    private final ProcesamientoId procesamientoId;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Cliente cliente;

    public ModificarClienteEnOrdenParaAlistamiento(
            ProcesamientoId procesamientoId,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Cliente cliente) {
        this.procesamientoId = procesamientoId;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.cliente = cliente;
    }

    public ProcesamientoId getProcesamientoId() {
        return procesamientoId;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
