package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.procesamiento.entities.EtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.entities.OrdenParaAlistamiento;
import co.com.sofka.domain.procesamiento.entities.Pedido;
import co.com.sofka.domain.procesamiento.events.*;

public class ProcesamientoChange extends EventChange {

    public ProcesamientoChange(Procesamiento procesamiento) {

        apply((ProcesamientoCreado event) -> {
            procesamiento.fechaProcesamiento = event.getFechaProcesamiento();
            procesamiento.procesador = event.getProcesador();
        });

        apply((OrdenParaAlistamientoCreada event)->{
            procesamiento.ordenParaAlistamiento = new OrdenParaAlistamiento(
                    event.getIdOrdenParaAlistamiento(),
                    event.getCodigo(),
                    event.getIdPedido(),
                    event.getCliente(),
                    event.getDireccionEntrega()
            );
        });

        apply((EtapaDelProcesamientoCreada event)->{
            procesamiento.etapaDelProcesamiento = new EtapaDelProcesamiento(
                    event.getIdEtapaDelProcesamiento(),
                    event.getFecha(),
                    event.getEtapa()
            );
        });

        apply((PedidoCreado event)->{
            procesamiento.pedido = new Pedido(
                    event.getIdPedido(),
                    event.getConsecutivo(),
                    event.getCliente(),
                    event.getDireccionEntrega()
            );
        });

        apply((ItemEnOrdenParaAlistamientoAgregado event)->{
            procesamiento.ordenParaAlistamiento.items().add(
                    event.getItem()
            );
        });

        apply((ItemEnPedidoAgregado event)->{
            procesamiento.ordenParaAlistamiento.items().add(
                    event.getItem()
            );
        });

        apply((EtapaEnEtapaDelProcesamientoModificada event)->{
            procesamiento.etapaDelProcesamiento.modificarEstadoProcesamiento(
                    event.getEtapa()
            );
        });

    }
}
