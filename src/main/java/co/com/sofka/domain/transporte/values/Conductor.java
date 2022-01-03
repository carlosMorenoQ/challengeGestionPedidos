package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Conductor implements ValueObject<String> {

    private final String value;

    public Conductor(String value) {
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
        Conductor conductor = (Conductor) o;
        return Objects.equals(value, conductor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
