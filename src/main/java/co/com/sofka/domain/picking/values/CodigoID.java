package co.com.sofka.domain.picking.values;

import co.com.sofka.domain.generic.Identity;

public class CodigoID extends Identity {

    public CodigoID(String uuid) {
        super(uuid);
    }

    public CodigoID() {
    }

    public static CodigoID of(String uuid) {
        return new CodigoID(uuid);
    }

}
