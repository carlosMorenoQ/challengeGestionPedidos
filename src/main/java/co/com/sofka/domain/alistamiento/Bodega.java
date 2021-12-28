package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.values.EstadoAlistamientoValue;
import co.com.sofka.domain.alistamiento.values.IdBodega;
import co.com.sofka.domain.alistamiento.values.IdEstadoAlistamiento;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generics.Descripcion;
import co.com.sofka.domain.generics.Fecha;
import co.com.sofka.domain.generics.Item;

import java.util.Map;
import java.util.Set;

public class Bodega extends Entity<IdBodega> {

    private final Set<Item> stock;

    public Bodega(IdBodega entityId, Set<Item> stock) {
        super(entityId);
        this.stock = stock;
    }

    public void agregarItemStock(Item stock){
        this.stock.add(stock);
    }

    public Set<Item> getStock() {
        return stock;
    }
}
