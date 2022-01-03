package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;

public class ClienteEnOrdeParaTransporteModificado extends DomainEvent {

    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final Cliente cliente;

    public ClienteEnOrdeParaTransporteModificado(
            IdOrdenParaTransporte idOrdenParaTransporte,
            Cliente cliente) {
        super("sofka.alistamiento.clienteEnOrdeParaTransporteModificado");
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.cliente = cliente;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
