package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {

    private final String value;

    public Placa(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placa placa = (Placa) o;
        return Objects.equals(value, placa.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
