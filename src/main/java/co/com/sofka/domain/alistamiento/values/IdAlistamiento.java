package co.com.sofka.domain.alistamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdAlistamiento extends Identity {

    public IdAlistamiento(String uuid) {
        super(uuid);
    }

    public IdAlistamiento() {
    }

    public static IdAlistamiento of(String uuid){
        return new IdAlistamiento(uuid);
    }
}
