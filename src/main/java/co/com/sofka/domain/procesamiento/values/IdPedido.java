package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdPedido extends Identity {

    public IdPedido(String uuid) {
        super(uuid);
    }

    public IdPedido() {
    }

    public static IdPedido of(String uuid){
        return new IdPedido(uuid);
    }
}
