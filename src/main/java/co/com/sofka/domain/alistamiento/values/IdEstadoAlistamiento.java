package co.com.sofka.domain.alistamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdEstadoAlistamiento extends Identity {

    public IdEstadoAlistamiento(String uuid) {
        super(uuid);
    }

    public IdEstadoAlistamiento() {
    }

    public static IdEstadoAlistamiento of(String uuid){
        return new IdEstadoAlistamiento(uuid);
    }
}
