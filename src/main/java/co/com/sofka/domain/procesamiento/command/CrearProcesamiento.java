package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.entities.EstadoProcesamiento;
import co.com.sofka.domain.procesamiento.entities.OrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.entities.Pedido;
import co.com.sofka.domain.procesamiento.values.Procesador;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class CrearProcesamiento extends Command {

    private final IdProcesamiento idProcesamiento;
    private final EstadoProcesamiento estadoProcesamiento;
    private final OrdenParaAlistamiento ordenParaAlistamiento;
    private final Pedido pedido;
    private final  Fecha fecha;
    private final Procesador procesador;

    public CrearProcesamiento(
            IdProcesamiento idProcesamiento,
            EstadoProcesamiento estadoProcesamiento,
            OrdenParaAlistamiento ordenParaAlistamiento,
            Pedido pedido,
            Fecha fecha,
            Procesador procesador) {
        this.idProcesamiento = idProcesamiento;
        this.estadoProcesamiento = estadoProcesamiento;
        this.ordenParaAlistamiento = ordenParaAlistamiento;
        this.pedido = pedido;
        this.fecha = fecha;
        this.procesador = procesador;
    }

    public IdProcesamiento getProcesamientoId() {
        return idProcesamiento;
    }

    public EstadoProcesamiento getEstadoProcesamiento() {
        return estadoProcesamiento;
    }

    public OrdenParaAlistamiento getOrdenParaAlistamiento() {
        return ordenParaAlistamiento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Procesador getProcesador() {
        return procesador;
    }
}
