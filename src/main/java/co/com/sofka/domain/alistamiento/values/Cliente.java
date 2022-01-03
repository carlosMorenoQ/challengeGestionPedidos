package co.com.sofka.domain.alistamiento.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cliente implements ValueObject<Cliente.Value> {

    private final String nombres;
    private final String apellidos;
    private final Integer telefono;
    private final String documentoIdentificacion;


    public Cliente(String nombres, String apellidos, Integer telefono, String documentoIdentificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.documentoIdentificacion = documentoIdentificacion;
    }

    @Override
    public Value value(){
        return new Value() {
            @Override
            public String nombres() {
                return nombres;
            }

            @Override
            public String apellidos() {
                return apellidos;
            }

            @Override
            public Integer telefono() {
                return telefono;
            }

            @Override
            public String documentoIdentificacion() {
                return documentoIdentificacion;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombres, cliente.nombres) && Objects.equals(apellidos, cliente.apellidos) && Objects.equals(telefono, cliente.telefono) && Objects.equals(documentoIdentificacion, cliente.documentoIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, apellidos, telefono, documentoIdentificacion);
    }

    public interface Value{
        String nombres();
        String apellidos();
        Integer telefono();
        String documentoIdentificacion();
    }


}
