package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Item implements ValueObject<Item.Value> {

    private final Descripcion descripcion;
    private final Cantidad cantidad;

    public Item (Descripcion descripcion, Cantidad cantidad){
        this.cantidad =cantidad;
        this.descripcion = descripcion;
    }



    @Override
    public Value value(){
        return new Value() {
            @Override
            public Descripcion descripcion() {
                return descripcion;
            }

            @Override
            public Cantidad cantidad() {
                return cantidad;
            }
        };
    }



    public interface Value{
        Descripcion descripcion();
        Cantidad cantidad();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(descripcion, item.descripcion) && Objects.equals(cantidad, item.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, cantidad);
    }
}
