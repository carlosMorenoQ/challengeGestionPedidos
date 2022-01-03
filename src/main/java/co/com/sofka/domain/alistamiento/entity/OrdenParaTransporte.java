package co.com.sofka.domain.alistamiento.entity;

import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericValues.Item;

import java.util.HashSet;
import java.util.Set;

public class OrdenParaTransporte extends Entity<IdOrdenParaTransporte> {

    private Codigo codigo;
    private Set<Item> items;
    private DireccionEntrega direccionEntrega;
    private PlacaVehiculo placaVehiculo;
    private Cliente cliente;

    public OrdenParaTransporte(
            IdOrdenParaTransporte entityId,
            Codigo codigo,
            DireccionEntrega direccionEntrega,
            PlacaVehiculo placaVehiculo,
            Cliente cliente) {
        super(entityId);
        this.codigo = codigo;
        this.items = new HashSet<>();
        this.direccionEntrega = direccionEntrega;
        this.placaVehiculo = placaVehiculo;
        this.cliente = cliente;
    }

    public Codigo codigo() {
        return codigo;
    }

    public Set<Item> items() {
        return items;
    }

    public DireccionEntrega direccionEntrega() {
        return direccionEntrega;
    }

    public PlacaVehiculo placaVehiculo() {
        return placaVehiculo;
    }

    public Cliente cliente() {
        return cliente;
    }

    public void modificarDireccionEntrega(DireccionEntrega direccionEntrega){
        this.direccionEntrega = direccionEntrega;
    }

    public void modificarPlacaVehiculo(PlacaVehiculo placaVehiculo){
        this.placaVehiculo = placaVehiculo;
    }

    public void agregarItem(Item item){
        this.items.add(item);
    }

    public void modificarCliente(Cliente cliente){
        this.cliente = cliente;
    }

}
