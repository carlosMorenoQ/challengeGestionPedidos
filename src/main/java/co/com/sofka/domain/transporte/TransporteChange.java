package co.com.sofka.domain.transporte;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.transporte.entities.DocumentoDeEntrega;
import co.com.sofka.domain.transporte.entities.EstadoDeEntrega;
import co.com.sofka.domain.transporte.entities.Vehiculo;
import co.com.sofka.domain.transporte.events.*;

public class TransporteChange extends EventChange {

    public TransporteChange(Transporte transporte) {

        apply((TransporteCreado event)->{
            transporte.idAlistamiento = event.getIdAlistamiento();
            transporte.fechaTransporte = event.getFechaTransporte();
        });

        apply((DocumentoDeEntregaCreado event)->{
            transporte.documentoDeEntrega = new DocumentoDeEntrega(
                    event.getIdDocumentoDeEntrega(),
                    event.getCodigo(),
                    event.getCliente(),
                    event.getDireccionEntrega(),
                    event.getFechaCreacion()
            );
        });

        apply((EstadoEntregaCreado event)->{

            transporte.estadoDeEntrega = new EstadoDeEntrega(
                    event.getIdEstadoDeEntrega(),
                    event.getFechaEstado(),
                    event.getEstado()
            );
        });

        apply((VehiculoCreado event)->{
            transporte.vehiculo = new Vehiculo(
                    event.getIdVehiculo(),
                    event.getPlaca(),
                    event.getConductor()
            );
        });

        apply((ItemEnDocumentoDeEntregaAgregado event)->{
            transporte.documentoDeEntrega.agregarItem(
                    event.getItem()
            );
        });

        apply((ConductorEnVehiculoModificado event)->{
            transporte.vehiculo.modificarConductor(
                    event.getConductor()
            );
        });

        apply((EstadoDeEntregaModificado event)->{
            transporte.estadoDeEntrega.modificarEstado(
                    event.getEstado()
            );
        });

    }
}
