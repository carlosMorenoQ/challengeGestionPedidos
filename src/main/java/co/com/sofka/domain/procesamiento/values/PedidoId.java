package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {

    public PedidoId(String uuid) {
        super(uuid);
    }

    public PedidoId() {
    }

    public static PedidoId of(String uuid){
        return new PedidoId(uuid);
    }
}
