package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.procesamiento.events.*;

import java.util.HashSet;

public class ProcesamientoChange extends EventChange {

    public ProcesamientoChange(Procesamiento procesamiento) {

        apply((ProcesamientoCreado event) -> {
            procesamiento.estadoProcesamiento = event.getEstadoProcesamiento();
            procesamiento.ordenParaAlistamiento = event.getOrdenParaAlistamiento();
            procesamiento.pedido = event.getPedido();
            procesamiento.fecha = event.getFecha();
            procesamiento.procesador = event.getProcesador();
        });

        apply((PedidoCreado event)->{
            procesamiento.pedido = new Pedido(
                    event.getPedidoId(),
                    event.getConsecutivo(),
                    new HashSet<>(),
                    event.getCliente(),
                    event.getDireccionEntrega()
            );
        });

        apply((EstadoProcesamientoCreado event)->{
            procesamiento.estadoProcesamiento = new EstadoProcesamiento(
                    event.getEstadoProcesamientoId(),
                    event.getFecha(),
                    event.getEstadoProcesamientov()
            );
        });

        apply((OrdenParaAlistamientoCreada event)->{
            procesamiento.ordenParaAlistamiento = new OrdenParaAlistamiento(
                    event.getOrdenParaAlistamientoId(),
                    event.getCodigo(),
                    event.getPedidoId(),
                    new HashSet<>(),
                    event.getCliente(),
                    event.getDireccionEntrega(),
                    event.getFecha()
            );
        });

        apply((ClienteDePedidoModificado event) -> {
            procesamiento.pedido.modificarCliente(event.getCliente());
        });

        apply((DireccionDePedidoModificada event) -> {
            procesamiento.pedido.modificarDireccion(event.getDireccionEntrega());
        });

        apply((ClienteEnOrdenParaAlistamientoModificado event) -> {
            procesamiento.ordenParaAlistamiento.modificarCliente(event.getCliente());
        });

        apply((DireccionEntregaEnOrdenParaAlistamientoModificada event) -> {
            procesamiento.ordenParaAlistamiento.modificarDireccionEntrega(
                    event.getDireccionEntrega()
            );
        });

        apply((EstadoProcesamientoModificado event) -> {
            procesamiento.estadoProcesamiento.modificarEstadoProcesamiento(event.getEstadoProcesamientov());
        });

        apply((ItemDePedidoAgregado event)->{
            procesamiento.pedido.agregarItem(event.getItem());
        });

        apply((ItemEnOrdenParaAlistamientoAgregado event)->{
            procesamiento.ordenParaAlistamiento.agregarItem(event.getItem());
        });

    }
}
