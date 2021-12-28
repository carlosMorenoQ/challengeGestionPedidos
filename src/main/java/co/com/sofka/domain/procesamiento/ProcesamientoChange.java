package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.procesamiento.events.ProcesamientoCreado;

public class ProcesamientoChange extends EventChange {

    public ProcesamientoChange(Procesamiento procesamiento) {

        apply((ProcesamientoCreado event) -> {
            procesamiento.estadoProcesamiento = event.getEstadoProcesamiento();
            procesamiento.ordenParaAlistamiento = event.getOrdenParaAlistamiento();
            procesamiento.pedido = event.getPedido();
            procesamiento.fecha = event.getFecha();
            procesamiento.procesador = event.getProcesador();
        });



    }
}
