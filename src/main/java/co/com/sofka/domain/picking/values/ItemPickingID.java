package co.com.sofka.domain.picking.values;

import co.com.sofka.domain.generic.Identity;

public class ItemPickingID extends Identity {

    public ItemPickingID(String uuid) {
        super(uuid);
    }

    public ItemPickingID() {
    }

    public static ItemPickingID of(String uuid) {
        return new ItemPickingID(uuid);
    }


}
