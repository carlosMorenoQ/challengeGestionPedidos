package co.com.sofka.domain.procesamiento.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.procesamiento.values.IdPedido;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

public class AgregarItemEnPedidoCommand extends Command {

    private final IdProcesamiento idProcesamiento;
    private final IdPedido idPedido;
    private final Item item;

    public AgregarItemEnPedidoCommand(
            IdProcesamiento idProcesamiento,
            IdPedido idPedido,
            Item item) {
        this.idProcesamiento = idProcesamiento;
        this.idPedido = idPedido;
        this.item = item;
    }

    public IdProcesamiento getIdProcesamiento() {
        return idProcesamiento;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Item getItem() {
        return item;
    }
}
