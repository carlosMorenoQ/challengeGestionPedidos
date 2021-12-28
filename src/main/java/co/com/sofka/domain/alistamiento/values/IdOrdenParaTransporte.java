package co.com.sofka.domain.alistamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdOrdenParaTransporte extends Identity {

    public IdOrdenParaTransporte(String uuid) {
        super(uuid);
    }

    public IdOrdenParaTransporte() {
    }

    public static IdOrdenParaTransporte of(String uuid){
        return new IdOrdenParaTransporte(uuid);
    }
}
