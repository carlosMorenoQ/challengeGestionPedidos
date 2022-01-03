package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.Identity;

public class IdTransporte extends Identity {

    public IdTransporte(String uuid) {
        super(uuid);
    }

    public IdTransporte() {
    }

    public static IdTransporte of(String uuid){
        return new IdTransporte(uuid);
    }
}
