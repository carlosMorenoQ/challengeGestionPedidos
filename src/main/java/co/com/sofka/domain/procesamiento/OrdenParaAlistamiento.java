package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generics.Fecha;
import co.com.sofka.domain.generics.Item;
import co.com.sofka.domain.procesamiento.values.*;

import java.util.Set;

public class OrdenParaAlistamiento extends Entity<OrdenParaAlistamientoId> {

    private final String codigo;
    private final PedidoId pedidoId;
    private final Set<Item> items;
    private Cliente cliente;
    private DireccionEntrega direccionEntrega;
    private final Fecha fecha;

    public OrdenParaAlistamiento(
            OrdenParaAlistamientoId entityId,
            String codigo, PedidoId pedidoId,
            Set<Item> items, Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fecha) {
        super(entityId);
        this.codigo = codigo;
        this.pedidoId = pedidoId;
        this.items = items;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fecha = fecha;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public void modificarCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void modificarDireccionEntrega(DireccionEntrega direccionEntrega){
        this.direccionEntrega=direccionEntrega;
    }


    public String codigo() {
        return codigo;
    }

    public PedidoId pedidoId() {
        return pedidoId;
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

    public Fecha fecha() {
        return fecha;
    }
}
