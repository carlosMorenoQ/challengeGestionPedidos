package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.Identity;

public class IdEstadoDeEntrega extends Identity {

    public IdEstadoDeEntrega(String uuid) {
        super(uuid);
    }

    public IdEstadoDeEntrega() {
    }

    public static IdEstadoDeEntrega of(String uuid){
        return new IdEstadoDeEntrega(uuid);
    }


}
