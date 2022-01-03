package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;
import co.com.sofka.domain.transporte.values.IdTransporte;

public class CrearEstadoEntregaCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdEstadoDeEntrega idEstadoDeEntrega;
    private final Fecha fechaEstado;
    private final Estado estado;

    public CrearEstadoEntregaCommand(
            IdTransporte idTransporte,
            IdEstadoDeEntrega idEstadoDeEntrega,
            Fecha fechaEstado,
            Estado estado) {
        this.idTransporte = idTransporte;
        this.idEstadoDeEntrega = idEstadoDeEntrega;
        this.fechaEstado = fechaEstado;
        this.estado = estado;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdEstadoDeEntrega getIdEstadoDeEntrega() {
        return idEstadoDeEntrega;
    }

    public Fecha getFechaEstado() {
        return fechaEstado;
    }

    public Estado getEstado() {
        return estado;
    }
}
