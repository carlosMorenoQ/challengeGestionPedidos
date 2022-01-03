package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdOrdenParaAlistamiento extends Identity {

    public IdOrdenParaAlistamiento(String uuid) {
        super(uuid);
    }

    public IdOrdenParaAlistamiento() {
    }

    public static IdOrdenParaAlistamiento of(String uuid){
        return new IdOrdenParaAlistamiento(uuid);
    }
}
