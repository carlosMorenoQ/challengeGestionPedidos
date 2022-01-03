package co.com.sofka.domain.transporte.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.transporte.values.Conductor;
import co.com.sofka.domain.transporte.values.IdVehiculo;
import co.com.sofka.domain.transporte.values.Placa;

public class Vehiculo extends Entity<IdVehiculo> {

    private final Placa placa;
    private Conductor conductor;

    public Vehiculo(
            IdVehiculo idVehiculo,
            Placa placa,
            Conductor conductor) {
        super(idVehiculo);
        this.placa = placa;
        this.conductor = conductor;
    }

    public void modificarConductor(Conductor conductor){
        this.conductor = conductor;
    }

    public Placa placa() {
        return placa;
    }

    public Conductor conductor() {
        return conductor;
    }

}
