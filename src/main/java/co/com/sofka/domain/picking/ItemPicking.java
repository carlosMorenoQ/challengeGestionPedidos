package co.com.sofka.domain.picking;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.picking.values.Cantidad;
import co.com.sofka.domain.picking.values.Descripcion;
import co.com.sofka.domain.picking.values.ItemPickingID;

public class ItemPicking extends Entity<ItemPickingID> {

    public Descripcion descripcion;
    public Cantidad cantidad;

    public ItemPicking(ItemPickingID entityId, Descripcion descripcion, Cantidad cantidad) {
        super(entityId);
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public void modificarCantidadItem(Cantidad cantidad){
        this.cantidad = cantidad;
    }

    public void modificarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    public Cantidad Cantidad() {
        return cantidad;
    }
}
