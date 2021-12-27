package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DocumentoIdentidad implements ValueObject<DocumentoIdentidad.Value> {

    private final NumeroIdentificacion numeroIdentificacion;
    private final TipoDocumentoIdentificacion tipoDocumentoIdentificacion;

    public DocumentoIdentidad(
            NumeroIdentificacion numeroIdentificacion,
            TipoDocumentoIdentificacion tipoDocumentoIdentificacion){
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }

    @Override
    public Value value() {
        return new Value() {
            @Override
            public NumeroIdentificacion numeroIdentificacion() {
                return null;
            }

            @Override
            public TipoDocumentoIdentificacion tipoDocumentoIdentificacion() {
                return null;
            }
        };
    }

    public interface Value{
        NumeroIdentificacion numeroIdentificacion();
        TipoDocumentoIdentificacion tipoDocumentoIdentificacion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoIdentidad that = (DocumentoIdentidad) o;
        return Objects.equals(numeroIdentificacion, that.numeroIdentificacion) && Objects.equals(tipoDocumentoIdentificacion, that.tipoDocumentoIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroIdentificacion, tipoDocumentoIdentificacion);
    }
}
