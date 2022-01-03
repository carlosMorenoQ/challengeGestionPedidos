package co.com.sofka.domain.procesamiento.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.procesamiento.values.*;

import java.util.Set;

public class OrdenParaAlistamiento extends Entity<IdOrdenParaAlistamiento> {

    private final String codigo;
    private final IdPedido idPedido;
    private final Set<Item> items;
    private Cliente cliente;
    private DireccionEntrega direccionEntrega;
    private final Fecha fecha;

    public OrdenParaAlistamiento(
            IdOrdenParaAlistamiento entityId,
            String codigo,
            IdPedido idPedido,
            Set<Item> items,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fecha) {
        super(entityId);
        this.codigo = codigo;
        this.idPedido = idPedido;
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

    public IdPedido pedidoId() {
        return idPedido;
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
