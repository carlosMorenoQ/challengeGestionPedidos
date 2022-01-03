package co.com.sofka.domain.procesamiento.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.genericvalues.Item;
import co.com.sofka.domain.procesamiento.values.*;

import java.util.HashSet;
import java.util.Set;

public class OrdenParaAlistamiento extends Entity<IdOrdenParaAlistamiento> {

    private final String codigo;
    private final IdPedido idPedido;
    private final Set<Item> items;
    private Cliente cliente;
    private DireccionEntrega direccionEntrega;

    public OrdenParaAlistamiento(
            IdOrdenParaAlistamiento entityId,
            String codigo,
            IdPedido idPedido,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        super(entityId);
        this.codigo = codigo;
        this.idPedido = idPedido;
        this.items = new HashSet<>();
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
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

}
