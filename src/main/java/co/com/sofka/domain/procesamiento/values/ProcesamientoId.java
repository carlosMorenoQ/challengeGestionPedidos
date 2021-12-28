package co.com.sofka.domain.procesamiento.values;

import co.com.sofka.domain.generic.Identity;

public class ProcesamientoId extends Identity {

    public ProcesamientoId(String uuid) {
        super(uuid);
    }

    public ProcesamientoId() {
    }

    public static ProcesamientoId of(String uuid){
        return new ProcesamientoId(uuid);
    }

}
