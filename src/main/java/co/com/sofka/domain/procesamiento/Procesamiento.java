package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.entities.EtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.entities.OrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.entities.Pedido;
import co.com.sofka.domain.procesamiento.events.*;
import co.com.sofka.domain.procesamiento.values.*;

import java.util.List;
import java.util.Objects;

public class Procesamiento extends AggregateEvent<IdProcesamiento> {

    protected EtapaDelProcesamiento etapaDelProcesamiento;
    protected OrdenParaAlistamiento ordenParaAlistamiento;
    protected Pedido pedido;
    protected Fecha fechaProcesamiento;
    protected Procesador procesador;

    public Procesamiento(
            IdProcesamiento idProcesamiento,
            Fecha fechaProcesamiento,
            Procesador procesador) {
        super(idProcesamiento);
        appendChange(new ProcesamientoCreado(
                fechaProcesamiento,
                procesador)).apply();
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


    public void crearOrdenParaAlistamiento(
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            String codigo,
            IdPedido idPedido,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        Objects.requireNonNull(idOrdenParaAlistamiento);
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(direccionEntrega);
        appendChange(new OrdenParaAlistamientoCreada(
                idOrdenParaAlistamiento,
                codigo,
                idPedido,
                cliente,
                direccionEntrega
        )).apply();
    }

    public void crearEtapaDelProcesamiento(
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Fecha fecha,
            Etapa etapa) {
        Objects.requireNonNull(idEtapaDelProcesamiento);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(etapa);
        appendChange(new EtapaDelProcesamientoCreada(
                idEtapaDelProcesamiento,
                fecha,
                etapa
        )).apply();
    }

    public void crearPedido(
            IdPedido idPedido,
            Consecutivo consecutivo,
            Cliente cliente,
            DireccionEntrega direccionEntrega) {
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(consecutivo);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(direccionEntrega);
        appendChange(new PedidoCreado(
                idPedido,
                consecutivo,
                cliente,
                direccionEntrega
        )).apply();
    }

    public void agregarItemEnOrdenParaAlistamiento(
            IdOrdenParaAlistamiento idOrdenParaAlistamiento,
            Item item) {
        Objects.requireNonNull(idOrdenParaAlistamiento);
        Objects.requireNonNull(item);
        appendChange(new ItemEnOrdenParaAlistamientoAgregado(
                idOrdenParaAlistamiento,
                item
        )).apply();
    }

    public void agregarItemEnPedido(
            IdPedido idPedido,
            Item item) {
        Objects.requireNonNull(idPedido);
        Objects.requireNonNull(item);
        appendChange(new ItemEnPedidoAgregado(
                idPedido,
                item
        )).apply();
    }

    public void modificarEtapaEnEtapaDelProcesamiento(
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Etapa etapa) {
        Objects.requireNonNull(idEtapaDelProcesamiento);
        Objects.requireNonNull(etapa);
        appendChange(new EtapaEnEtapaDelProcesamientoModificada(
                idEtapaDelProcesamiento,
                etapa
        )).apply();
    }


    public EtapaDelProcesamiento etapaDelProcesamiento() {
        return etapaDelProcesamiento;
    }

    public OrdenParaAlistamiento ordenParaAlistamiento() {
        return ordenParaAlistamiento;
    }

    public Pedido pedido() {
        return pedido;
    }

    public Fecha fecha() {
        return fechaProcesamiento;
    }

    public Procesador procesador() {
        return procesador;
    }
}
