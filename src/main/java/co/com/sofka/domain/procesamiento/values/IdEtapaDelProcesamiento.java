package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdEtapaDelProcesamiento extends Identity {

    public IdEtapaDelProcesamiento(String uuid) {
        super(uuid);
    }

    public IdEtapaDelProcesamiento() {
    }

    public static IdEtapaDelProcesamiento of (String uuid){
        return new IdEtapaDelProcesamiento();
    }
}
