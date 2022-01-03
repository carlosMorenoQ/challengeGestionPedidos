package co.com.sofka.domain.alistamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdEtapaDelAlistamiento extends Identity {

    public IdEtapaDelAlistamiento(String uuid) {
        super(uuid);
    }

    public IdEtapaDelAlistamiento() {
    }

    public static IdEtapaDelAlistamiento of(String uuid){
        return new IdEtapaDelAlistamiento(uuid);
    }
}
