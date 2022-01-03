package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;
import co.com.sofka.domain.transporte.values.IdTransporte;

public class ModificarEstadoDeEntregaCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdEstadoDeEntrega idEstadoDeEntrega;
    private final Estado estado;


    public ModificarEstadoDeEntregaCommand(
            IdTransporte idTransporte,
            IdEstadoDeEntrega idEstadoDeEntrega,
            Estado estado) {
        this.idTransporte = idTransporte;
        this.idEstadoDeEntrega = idEstadoDeEntrega;
        this.estado = estado;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdEstadoDeEntrega getIdEstadoDeEntrega() {
        return idEstadoDeEntrega;
    }

    public Estado getEstado() {
        return estado;
    }
}
