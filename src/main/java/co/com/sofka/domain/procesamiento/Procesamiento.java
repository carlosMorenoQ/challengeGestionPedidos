package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.entities.EstadoProcesamiento;
import co.com.sofka.domain.procesamiento.entities.OrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.entities.Pedido;
import co.com.sofka.domain.procesamiento.events.*;
import co.com.sofka.domain.procesamiento.values.*;

import java.util.List;
import java.util.Objects;

public class Procesamiento extends AggregateEvent<IdProcesamiento> {

    protected EstadoProcesamiento estadoProcesamiento;
    protected OrdenParaAlistamiento ordenParaAlistamiento;
    protected Pedido pedido;
    protected Fecha fecha;
    protected Procesador procesador;

    public Procesamiento(
            IdProcesamiento entityId,
            EstadoProcesamiento estadoProcesamiento,
            OrdenParaAlistamiento ordenParaAlistamiento,
            Pedido pedido, Fecha fecha,
            Procesador procesador) {
        super(entityId);
        this.estadoProcesamiento = estadoProcesamiento;
        this.ordenParaAlistamiento = ordenParaAlistamiento;
        this.pedido = pedido;
        this.fecha = fecha;
        this.procesador = procesador;
    }

    public Procesamiento(IdProcesamiento entityId) {
        super(entityId);
        subscribe(new ProcesamientoChange(this));
    }

    public static Procesamiento from(
            IdProcesamiento idProcesamiento,
            List<DomainEvent> events) {
        var procesamiento = new Procesamiento(idProcesamiento);
        events.forEach(procesamiento::applyEvent);
        return procesamiento;
    }


    public void agregarItemDePedido(PedidoId pedidoId, Item item) {
        Objects.requireNonNull(item);
        Objects.requireNonNull(pedidoId);
        appendChange(new ItemDePedidoAgregado(
                pedidoId,
                item
        )).apply();
    }

    public void modificarClienteDePedido(PedidoId pedidoId, Cliente cliente) {
        Objects.requireNonNull(pedidoId);
        Objects.requireNonNull(cliente);
        appendChange(new ClienteDePedidoModificado(pedidoId, cliente)).apply();
    }

    public void modificarDireccionDePedido(
            PedidoId pedidoId,
            DireccionEntrega direccionEntrega) {

        Objects.requireNonNull(pedidoId);
        Objects.requireNonNull(direccionEntrega);
        appendChange(new DireccionDePedidoModificada(
                pedidoId,
                direccionEntrega
        )).apply();
    }

    public void agregarItemEnOrdenParaAlistamiento(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Item item) {
        Objects.requireNonNull(ordenParaAlistamientoId);
        Objects.requireNonNull(item);
        appendChange(new ItemEnOrdenParaAlistamientoAgregado(
                ordenParaAlistamientoId,
                item
        )).apply();
    }

    public void modificarClienteEnOrdenParaAlistamiento(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            Cliente cliente) {
        Objects.requireNonNull(ordenParaAlistamientoId);
        Objects.requireNonNull(cliente);
        appendChange(new ClienteEnOrdenParaAlistamientoModificado(
                ordenParaAlistamientoId,
                cliente
        )).apply();
    }

    public void modificarDireccionEntregaEnOrdenParaAlistamiento(
            OrdenParaAlistamientoId ordenParaAlistamientoId,
            DireccionEntrega direccionEntrega) {
        Objects.requireNonNull(ordenParaAlistamientoId);
        Objects.requireNonNull(direccionEntrega);
        appendChange(new DireccionEntregaEnOrdenParaAlistamientoModificada(
                ordenParaAlistamientoId,
                direccionEntrega
        )).apply();
    }

    public void modificarEstadoProcesamiento(
            EstadoProcesamientoId estadoProcesamientoId,
            EstadoProcesamientov estadoProcesamientov) {
        Objects.requireNonNull(estadoProcesamientov);
        Objects.requireNonNull(estadoProcesamientoId);
        appendChange(new EstadoProcesamientoModificado(
                estadoProcesamientoId,
                estadoProcesamientov
        )).apply();
    }


    public EstadoProcesamiento estadoProcesamiento() {
        return estadoProcesamiento;
    }

    public OrdenParaAlistamiento ordenParaAlistamiento() {
        return ordenParaAlistamiento;
    }

    public Pedido pedido() {
        return pedido;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Procesador procesador() {
        return procesador;
    }
}
