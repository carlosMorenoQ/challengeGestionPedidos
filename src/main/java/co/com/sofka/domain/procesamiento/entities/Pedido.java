package co.com.sofka.domain.procesamiento.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.Cliente;
import co.com.sofka.domain.procesamiento.values.Consecutivo;
import co.com.sofka.domain.procesamiento.values.DireccionEntrega;
import co.com.sofka.domain.procesamiento.values.PedidoId;

import java.util.Set;

public class Pedido extends Entity<PedidoId> {

    private final Consecutivo consecutivo;
    private final Set<Item> items;
    private Cliente cliente;
    private DireccionEntrega direccionEntrega;

    public Pedido(
            PedidoId entityId,
            Consecutivo consecutivo,
            Set<Item> items,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        super(entityId);
        this.consecutivo = consecutivo;
        this.items = items;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
    }


    public void agregarItem(Item item){
        this.items.add(item);
    }

    public void modificarCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void modificarDireccion(DireccionEntrega direccionEntrega){
        this.direccionEntrega = direccionEntrega;
    }

    public Consecutivo consecutivo() {
        return consecutivo;
    }

    public Set<Item> items() {
        return items;
    }

    public Cliente cliente() {
        return cliente;
    }

    public DireccionEntrega direccionEntrega() {
        return direccionEntrega;
    }
}
