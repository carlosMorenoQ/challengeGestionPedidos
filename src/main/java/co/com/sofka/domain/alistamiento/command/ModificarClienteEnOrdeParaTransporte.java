package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Cliente;

public class ModificarClienteEnOrdeParaTransporte extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final Cliente cliente;

    public ModificarClienteEnOrdeParaTransporte(
            IdAlistamiento idAlistamiento,
            IdOrdenParaTransporte idOrdenParaTransporte,
            Cliente cliente) {
        this.idAlistamiento = idAlistamiento;
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.cliente = cliente;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
