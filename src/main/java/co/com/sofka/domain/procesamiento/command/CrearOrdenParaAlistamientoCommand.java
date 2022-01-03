package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procesamiento.values.*;

public class CrearOrdenParaAlistamientoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdOrdenParaAlistamiento idOrdenParaAlistamiento;
    private final String codigo;
    private final IdPedido idPedido;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;

    public CrearOrdenParaAlistamientoCommand(
            IdProcesamiento idProcesamiento,
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            String codigo,
            IdPedido idPedido,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        this.idProcesamiento = idProcesamiento;
        this.idOrdenParaAlistamiento = idOrdenParaAlistamiento;
        this.codigo = codigo;
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
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
