package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.Identity;

public class IdVehiculo extends Identity {

    public IdVehiculo(String uuid) {
        super(uuid);
    }

    public IdVehiculo() {
    }

    public static IdVehiculo of(String uuid){
        return new IdVehiculo(uuid);
    }

}
