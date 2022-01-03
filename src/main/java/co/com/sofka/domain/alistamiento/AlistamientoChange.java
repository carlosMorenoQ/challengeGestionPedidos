package co.com.sofka.domain.alistamiento;

import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.entity.EtapaDelAlistamiento;
import co.com.sofka.domain.alistamiento.entity.OrdenParaTransporte;
import co.com.sofka.domain.alistamiento.events.*;
import co.com.sofka.domain.generic.EventChange;

public class AlistamientoChange extends EventChange {

    public AlistamientoChange(Alistamiento alistamiento){

        apply((AlistamientoCreado event)->{
            alistamiento.fechaAlistamiento = event.getFechaAlistamiento();
        });

        apply((ClienteEnOrdeParaTransporteModificado event)->{
            alistamiento.ordenParaTransporte.modificarCliente(
                    event.getCliente()
            );
        });

        apply((DireccionEnOrdenParaTransporteModificada event)->{
            alistamiento.ordenParaTransporte.modificarDireccionEntrega(
                    event.getDireccionEntrega()
            );
        });

        apply((EtapaDelAlistamientoAgregada event)->{
            alistamiento.etapaDelAlistamiento = new EtapaDelAlistamiento(
                    event.getEntityId(),
                    event.getFechaEtapa(),
                    event.getEtapa()
            );
        });

        apply((EtapaEnEtapaDelAlistamientoModificada event)->{
            alistamiento.etapaDelAlistamiento.modificarEtapa(
                    event.getEtapa(),
                    event.getFecha()
            );
        });

        apply((FechaAlistamientoCambiada event)->{
            alistamiento.fechaAlistamiento = event.getFechaAlistamiento();
        });

        apply((ItemEnOrdenParaTransporteAgregado event)->{
            alistamiento.ordenParaTransporte.agregarItem(
                    event.getItem()
            );
        });

        apply((OrdenParaTransporteAgregada event)->{
            alistamiento.ordenParaTransporte = new OrdenParaTransporte(
                    event.getEntityId(),
                    event.getCodigo(),
                    event.getDireccionEntrega(),
                    event.getPlacaVehiculo(),
                    event.getCliente()
            );
        });

        apply((PlacaVehiculoEnOrdenParaTransporteModificada event)->{
            alistamiento.ordenParaTransporte.modificarPlacaVehiculo(
                    event.getPlacaVehiculo()
            );
        });

        apply((ProcesamientoAsociado event)->{
            alistamiento.idProcesamiento = event.getIdProcesamiento();
        });

    }

}
