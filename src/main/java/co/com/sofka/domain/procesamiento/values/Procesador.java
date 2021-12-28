package co.com.sofka.domain.procesamiento.values;


import co.com.sofka.domain.generic.ValueObject;

public class Procesador implements ValueObject<Procesador.Value> {

    private final String nombres;
    private final String apellidos;

    public Procesador(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
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
        };
    }

    public interface Value{
        String nombres();
        String apellidos();
    }


}
