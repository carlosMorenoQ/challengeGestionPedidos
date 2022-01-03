package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.entity.EtapaDelAlistamiento;
import co.com.sofka.domain.alistamiento.entity.OrdenParaTransporte;
import co.com.sofka.domain.alistamiento.events.*;
import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.genericValues.Item;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;

import java.util.List;
import java.util.Objects;

public class Alistamiento extends AggregateEvent<IdAlistamiento> {

    protected IdProcesamiento idProcesamiento;
    protected OrdenParaTransporte ordenParaTransporte;
    protected EtapaDelAlistamiento etapaDelAlistamiento;
    protected Fecha fechaAlistamiento;

    public Alistamiento(IdAlistamiento entityId, Fecha fechaAlistamiento) {
        super(entityId);
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(fechaAlistamiento);
        appendChange(new AlistamientoCreado(fechaAlistamiento)).apply();
    }

    private Alistamiento(IdAlistamiento idAlistamiento) {
        super(idAlistamiento);
        subscribe(new AlistamientoChange(this));
    }

    public static Alistamiento from(IdAlistamiento idAlistamiento, List<DomainEvent> events) {
        var alistamiento = new Alistamiento(idAlistamiento);
        events.forEach(alistamiento::applyEvent);
        return alistamiento;
    }

    public void agregarOrdenParaTransporte(
            IdOrdenParaTransporte entityId,
            Codigo codigo,
            DireccionEntrega direccionEntrega,
            PlacaVehiculo placaVehiculo,
            Cliente cliente) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(direccionEntrega);
        Objects.requireNonNull(placaVehiculo);
        Objects.requireNonNull(cliente);
        appendChange(new OrdenParaTransporteAgregada(
                entityId,
                codigo,
                direccionEntrega,
                placaVehiculo,
                cliente
        )).apply();
    }

    public void agregarEtapaDelAlistamiento(
            IdEtapaDelAlistamiento entityId,
            Fecha fechaEtapa,
            Etapa etapa) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(fechaEtapa);
        Objects.requireNonNull(etapa);
        appendChange(new EtapaDelAlistamientoAgregada(
                entityId,
                fechaEtapa,
                etapa
        )).apply();
    }

    public void asociarProcesamiento(IdProcesamiento idProcesamiento) {
        Objects.requireNonNull(idProcesamiento);
        appendChange(new ProcesamientoAsociado(idProcesamiento)).apply();
    }

    public void cambiarFechaAlistamiento(Fecha fechaAlistamiento) {
        Objects.requireNonNull(fechaAlistamiento);
        appendChange(new FechaAlistamientoCambiada(fechaAlistamiento)).apply();
    }

    public void agregarItemEnOrdenParaTransporte(
            IdOrdenParaTransporte idOrdenParaTransporte,
            Item item) {
        Objects.requireNonNull(item);
        appendChange(new ItemEnOrdenParaTransporteAgregado(
                idOrdenParaTransporte,
                item
        )).apply();
    }

    public void modificarDireccionEnOrdenParaTransporte(
            IdOrdenParaTransporte idOrdenParaTransporte,
            DireccionEntrega direccionEntrega) {
        Objects.requireNonNull(idOrdenParaTransporte);
        Objects.requireNonNull(direccionEntrega);
        appendChange(new DireccionEnOrdenParaTransporteModificada(
                idOrdenParaTransporte,
                direccionEntrega
        )).apply();
    }

    public void modificarPlacaVehiculoEnOrdenParaTransporte(
            IdOrdenParaTransporte idOrdenParaTransporte,
            PlacaVehiculo placaVehiculo) {
        Objects.requireNonNull(idOrdenParaTransporte);
        Objects.requireNonNull(placaVehiculo);
        appendChange(new PlacaVehiculoEnOrdenParaTransporteModificada(
                idOrdenParaTransporte,
                placaVehiculo
        )).apply();
    }

    public void modificarClienteEnOrdeParaTransporte(
            IdOrdenParaTransporte idOrdenParaTransporte,
            Cliente cliente) {
        Objects.requireNonNull(idOrdenParaTransporte);
        Objects.requireNonNull(cliente);
        appendChange(new ClienteEnOrdeParaTransporteModificado(
                idOrdenParaTransporte,
                cliente
        )).apply();
    }

    public void modificarEtapaEnEtapaDelAlistamiento(
            IdEtapaDelAlistamiento idEtapaDelAlistamiento,
            Fecha fecha,
            Etapa etapa) {
        Objects.requireNonNull(idEtapaDelAlistamiento);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(etapa);
        appendChange(new EtapaEnEtapaDelAlistamientoModificada(
                idEtapaDelAlistamiento,
                fecha,
                etapa
        )).apply();
    }

    public IdProcesamiento idProcesamiento() {
        return idProcesamiento;
    }

    public OrdenParaTransporte ordenParaTransporte() {
        return ordenParaTransporte;
    }

    public EtapaDelAlistamiento etapaDelAlistamiento() {
        return etapaDelAlistamiento;
    }

    public Fecha fechaAlistamiento() {
        return fechaAlistamiento;
    }

}
