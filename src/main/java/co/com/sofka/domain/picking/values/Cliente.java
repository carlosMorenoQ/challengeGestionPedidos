package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

public class Cliente implements ValueObject<Cliente.Value> {

    private final Nombres nombres;
    private final Telefono telefono;
    private final DocumentoIdentidad documentoIdentidad;

    public Cliente(
            Nombres nombres,
            Telefono telefono,
            DocumentoIdentidad documentoIdentidad){
        this.nombres = nombres;
        this.telefono = telefono;
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public Value value(){
        return new Value() {
            @Override
            public Nombres nombres() {
                return nombres;
            }

            @Override
            public Telefono telefono() {
                return telefono;
            }

            @Override
            public DocumentoIdentidad documentoIdentidad() {
                return documentoIdentidad;
            }
        };
    }


    public interface Value{
        Nombres nombres();
        Telefono telefono();
        DocumentoIdentidad documentoIdentidad();
    }

}
