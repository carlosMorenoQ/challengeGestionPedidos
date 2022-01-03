package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdProcesamiento extends Identity {

    public IdProcesamiento(String uuid) {
        super(uuid);
    }

    public IdProcesamiento() {
    }

    public static IdProcesamiento of(String uuid){
        return new IdProcesamiento(uuid);
    }

}
