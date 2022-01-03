package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.values.*;


public class CrearOrdenParaAlistamiento extends Command {

    private final OrdenParaAlistamientoId ordenParaAlistamientoId;
    private final String codigo;
    private final PedidoId pedidoId;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;
    private final Fecha fecha;

    public CrearOrdenParaAlistamiento(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            String codigo,
            PedidoId pedidoId,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fecha) {
        this.ordenParaAlistamientoId = ordenParaAlistamientoId;
        this.codigo = codigo;
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fecha = fecha;
    }

    public OrdenParaAlistamientoId getOrdenParaAlistamientoId() {
        return ordenParaAlistamientoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public Fecha getFecha() {
        return fecha;
    }

}
