package co.com.sofka.domain.transporte.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.values.Conductor;
import co.com.sofka.domain.transporte.values.IdVehiculo;

public class ConductorEnVehiculoModificado extends DomainEvent {


    private final IdVehiculo idVehiculo;
    private final Conductor conductor;

    public ConductorEnVehiculoModificado(
            IdVehiculo idVehiculo,
            Conductor conductor) {
        super("sofka.transporte.ConductorEnVehiculoModificado");

        this.idVehiculo = idVehiculo;
        this.conductor = conductor;
    }

    public IdVehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

}
