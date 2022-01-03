package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.Codigo;
import co.com.sofka.domain.genericvalues.DireccionEntrega;

public class OrdenParaTransporteAgregada extends DomainEvent {

    private final IdOrdenParaTransporte entityId;
    private final Codigo codigo;
    private final DireccionEntrega direccionEntrega;
    private final PlacaVehiculo placaVehiculo;
    private final Cliente cliente;


    public OrdenParaTransporteAgregada(
            IdOrdenParaTransporte entityId,
            Codigo codigo,
            DireccionEntrega direccionEntrega,
            PlacaVehiculo placaVehiculo,
            Cliente cliente) {
        super("sofka.alistamiento.ordenParaTransporteAgregada");
        this.entityId = entityId;
        this.codigo = codigo;
        this.direccionEntrega = direccionEntrega;
        this.placaVehiculo = placaVehiculo;
        this.cliente = cliente;
    }

    public IdOrdenParaTransporte getEntityId() {
        return entityId;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public PlacaVehiculo getPlacaVehiculo() {
        return placaVehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
