package co.com.sofka.domain.picking.values;

import co.com.sofka.domain.generic.Identity;

public class ProcesadorID extends Identity {

    public ProcesadorID(String uuid) {
        super(uuid);
    }

    public ProcesadorID() {
    }

    public static ProcesadorID of(String uuid){
        return new ProcesadorID(uuid);
    }

}
