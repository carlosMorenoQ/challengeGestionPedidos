package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.OrdenParaAlistamientoId;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class ModificarClienteEnOrdenParaAlistamiento extends Command {

    private final IdProcesamiento idProcesamiento;
    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final Cliente cliente;

    public ModificarClienteEnOrdenParaAlistamiento(
            IdProcesamiento idProcesamiento,
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Cliente cliente) {
        this.idProcesamiento = idProcesamiento;
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.cliente = cliente;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
