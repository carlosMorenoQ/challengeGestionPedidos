package co.com.sofka.domain.alistamiento.values;

import co.com.sofka.domain.generic.Identity;

public class IdBodega extends Identity {

    public IdBodega(String uuid) {
        super(uuid);
    }

    public IdBodega() {
    }

    public static IdBodega of(String uuid){
        return new IdBodega(uuid);
    }
}
