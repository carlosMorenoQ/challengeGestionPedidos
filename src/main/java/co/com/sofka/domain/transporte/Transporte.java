package co.com.sofka.domain.transporte;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.*;
import co.com.sofka.domain.transporte.entities.DocumentoDeEntrega;
import co.com.sofka.domain.transporte.entities.EstadoDeEntrega;
import co.com.sofka.domain.transporte.entities.Vehiculo;
import co.com.sofka.domain.transporte.events.*;
import co.com.sofka.domain.transporte.values.*;

import java.util.List;
import java.util.Objects;

public class Transporte extends AggregateEvent<IdTransporte> {

    protected IdAlistamiento idAlistamiento;
    protected Vehiculo vehiculo;
    protected EstadoDeEntrega estadoDeEntrega;
    protected DocumentoDeEntrega documentoDeEntrega;
    protected Fecha fechaTransporte;

    public Transporte(IdTransporte idTransporte,
                      IdAlistamiento idAlistamiento,
                      Fecha fechaTransporte) {
        super(idTransporte);
        appendChange(new TransporteCreado(
                idAlistamiento,
                fechaTransporte
        )).apply();

    }

    public Transporte(IdTransporte idTransporte){
        super(idTransporte);
        subscribe(new TransporteChange(this));
    }

    public static Transporte from(IdTransporte idTransporte, List<DomainEvent> events){
        var transporte = new Transporte(idTransporte);
        events.forEach(transporte::applyEvent);
        return transporte;
    }

    public void crearDocumentoDeEntrega(
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Codigo codigo,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fechaCreacion){
        Objects.requireNonNull(idDocumentoDeEntrega);
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(direccionEntrega);
        Objects.requireNonNull(fechaCreacion);
        appendChange(new DocumentoDeEntregaCreado(
                idDocumentoDeEntrega,
                codigo,
                cliente,
                direccionEntrega,
                fechaCreacion
        )).apply();
    }

    public void crearEstadoEntrega(
            IdEstadoDeEntrega idEstadoDeEntrega,
            Fecha fechaEstado,
            Estado estado){
        Objects.requireNonNull(idEstadoDeEntrega);
        Objects.requireNonNull(fechaEstado);
        Objects.requireNonNull(estado);
        appendChange(new EstadoEntregaCreado(
                idEstadoDeEntrega,
                fechaEstado,
                estado
        )).apply();
    }

    public void crearVehiculo(
            IdVehiculo idVehiculo,
            Placa placa,
            Conductor conductor){
        Objects.requireNonNull(idVehiculo);
        Objects.requireNonNull(placa);
        Objects.requireNonNull(conductor);
        appendChange(new VehiculoCreado(
                idVehiculo,
                placa,
                conductor
        )).apply();
    }

    public void agregarItemEnDocumentoDeEntrega(
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Item item){
        Objects.requireNonNull(idDocumentoDeEntrega);
        Objects.requireNonNull(item);
        appendChange(new ItemEnDocumentoDeEntregaAgregado(
                idDocumentoDeEntrega,
                item
        )).apply();
    }

    public void modificarConductorEnVehiculo(
            IdVehiculo idVehiculo,
            Conductor conductor){
        Objects.requireNonNull(idVehiculo);
        Objects.requireNonNull(conductor);
        appendChange(new ConductorEnVehiculoModificado(
                idVehiculo,
                conductor
        )).apply();
    }

    public void modificarEstadoDeEntrega(
            IdEstadoDeEntrega idEstadoDeEntrega,
            Estado estado){
        Objects.requireNonNull(idEstadoDeEntrega);
        Objects.requireNonNull(estado);
        appendChange(new EstadoDeEntregaModificado(
                idEstadoDeEntrega,
                estado
        )).apply();
    }

    public IdAlistamiento alistamiento() {
        return idAlistamiento;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }

    public EstadoDeEntrega estadoDeEntrega() {
        return estadoDeEntrega;
    }

    public DocumentoDeEntrega documentoDeEntrega() {
        return documentoDeEntrega;
    }

    public Fecha fechaTransporte() {
        return fechaTransporte;
    }
}


