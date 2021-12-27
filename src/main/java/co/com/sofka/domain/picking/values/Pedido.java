package co.com.sofka.domain.picking.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class Pedido implements ValueObject<Pedido.Value> {

    private final Consecutivo consecutivo;
    private final Set<Item> items;
    private final Cliente cliente;
    private final DireccionPedidio direccionPedido;

    public Pedido(
            Consecutivo consecutivo,
            Set<Item> items,
            Cliente cliente,
            DireccionPedidio direccionPedido){

        this.consecutivo =consecutivo;
        this.items = items;
        this.cliente = cliente;
        this.direccionPedido = direccionPedido;
    }


    @Override
    public Value value(){
        return new Value() {
            @Override
            public Consecutivo consecutivo() {
                return consecutivo;
            }

            @Override
            public Set<Item> items() {
                return items;
            }

            @Override
            public Cliente cliente() {
                return cliente;
            }

            @Override
            public DireccionPedidio direccionPedido() {
                return direccionPedido;
            }
        };
    }


    public interface Value{
        Consecutivo consecutivo();
        Set<Item> items();
        Cliente cliente();
        DireccionPedidio direccionPedido();
    }


}
