package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DireccionPedidio implements ValueObject<DireccionPedidio.Value> {

    private final Departamento departamento;
    private final Ciudad ciudad;
    private final Direccion direccion;

    public DireccionPedidio(
            Departamento departamento,
            Ciudad ciudad,
            Direccion direccion) {

        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;

    }


    @Override
    public Value value(){

        return new Value() {
            @Override
            public Departamento departamento() {
                return departamento;
            }

            @Override
            public Ciudad ciudad() {
                return ciudad;
            }

            @Override
            public Direccion direccion() {
                return direccion;
            }
        };


    }

    public interface Value{
        Departamento departamento();
        Ciudad ciudad();
        Direccion direccion();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DireccionPedidio that = (DireccionPedidio) o;
        return Objects.equals(departamento, that.departamento) && Objects.equals(ciudad, that.ciudad) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamento, ciudad, direccion);
    }
}
