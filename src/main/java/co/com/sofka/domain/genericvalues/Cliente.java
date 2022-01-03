package co.com.sofka.domain.genericvalues;


import co.com.sofka.domain.generic.ValueObject;

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

    public interface Value{
        String nombres();
        String apellidos();
        Integer telefono();
        String documentoIdentificacion();
    }


}
