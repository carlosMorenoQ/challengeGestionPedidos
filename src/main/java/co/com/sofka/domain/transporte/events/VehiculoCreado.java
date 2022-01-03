package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.values.Conductor;
import co.com.sofka.domain.transporte.values.IdVehiculo;
import co.com.sofka.domain.transporte.values.Placa;

public class VehiculoCreado extends DomainEvent {

    private final IdVehiculo idVehiculo;
    private final Placa placa;
    private final Conductor conductor;

    public VehiculoCreado(
            IdVehiculo idVehiculo,
            Placa placa,
            Conductor conductor) {
        super("sofka.transporte.VehiculoCreado");
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.conductor = conductor;
    }

    public IdVehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Conductor getConductor() {
        return conductor;
    }
}
