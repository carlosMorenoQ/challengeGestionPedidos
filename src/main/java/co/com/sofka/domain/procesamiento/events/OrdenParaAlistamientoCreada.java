package co.com.sofka.domain.procesamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.IdOrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.values.IdPedido;

public class OrdenParaAlistamientoCreada extends DomainEvent {

    private final IdOrdenParaAlistamiento idOrdenParaAlistamiento;
    private final String codigo;
    private final IdPedido idPedido;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public OrdenParaAlistamientoCreada(
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            String codigo,
            IdPedido idPedido,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        super("sofka.procesamiento.ordenparaalistamientocreada");
        this.idOrdenParaAlistamiento = idOrdenParaAlistamiento;
        this.codigo = codigo;
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public IdOrdenParaAlistamiento getIdOrdenParaAlistamiento() {
        return idOrdenParaAlistamiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
