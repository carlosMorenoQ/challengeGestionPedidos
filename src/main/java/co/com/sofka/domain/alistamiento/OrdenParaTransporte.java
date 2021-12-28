package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.values.Codigo;
import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generics.Item;

import java.util.Set;

public class OrdenParaTransporte extends Entity<IdOrdenParaTransporte> {

    private final Codigo codigo;
    private final Set<Item> items;

    public OrdenParaTransporte(
            IdOrdenParaTransporte entityId,
            Codigo codigo,
            Set<Item> items) {
        super(entityId);
        this.codigo = codigo;
        this.items = items;
    }

    public Codigo codigo() {
        return codigo;
    }

    public Set<Item> items() {
        return items;
    }
}
