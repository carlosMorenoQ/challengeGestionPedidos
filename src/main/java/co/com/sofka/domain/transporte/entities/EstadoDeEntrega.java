package co.com.sofka.domain.transporte.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;

public class EstadoDeEntrega extends Entity<IdEstadoDeEntrega> {

    private Fecha fechaEstado;
    private Estado estado;

    public EstadoDeEntrega(
            IdEstadoDeEntrega idEstadoDeEntrega,
            Fecha fechaEstado,
            Estado estado) {
        super(idEstadoDeEntrega);
        this.fechaEstado = fechaEstado;
        this.estado = estado;
    }

    public void modificarEstado(
            Estado estado) {
        this.estado = estado;
    }


    public Fecha fechaEstado() {
        return fechaEstado;
    }

    public Estado estado() {
        return estado;
    }
}
