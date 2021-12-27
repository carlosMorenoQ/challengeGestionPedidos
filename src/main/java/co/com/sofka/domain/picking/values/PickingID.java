package co.com.sofka.domain.picking.values;

import co.com.sofka.domain.generic.Identity;

public class PickingID extends Identity {

    public PickingID(String uuid) {
        super(uuid);
    }

    public PickingID() {
    }

    public static PickingID of(String uuid){
        return new PickingID(uuid);
    }

}
