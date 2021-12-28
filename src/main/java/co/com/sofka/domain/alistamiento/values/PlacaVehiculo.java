package co.com.sofka.domain.alistamiento.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PlacaVehiculo implements ValueObject<String> {

    private final String value;

    public PlacaVehiculo(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlacaVehiculo that = (PlacaVehiculo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }



}
