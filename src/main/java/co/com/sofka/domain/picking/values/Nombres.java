package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombres implements ValueObject<Nombres.Value> {

    private final Nombre nombre;
    private final Apellido apellido;


    public Nombres (Nombre nombre, Apellido apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }


    @Override
    public Value value() {
        return new Value() {
            @Override
            public Nombre nombre() {
                return nombre;
            }

            @Override
            public Apellido apellido() {
                return apellido;
            }
        };
    }

    public interface Value {
        Nombre nombre();
        Apellido apellido();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombres nombres = (Nombres) o;
        return Objects.equals(nombre, nombres.nombre) && Objects.equals(apellido, nombres.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
