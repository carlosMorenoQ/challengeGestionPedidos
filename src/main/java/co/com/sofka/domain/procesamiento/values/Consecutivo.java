package co.com.sofka.domain.procesamiento.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Consecutivo implements ValueObject<Integer> {

    private final Integer value;

    public Consecutivo(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consecutivo that = (Consecutivo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
