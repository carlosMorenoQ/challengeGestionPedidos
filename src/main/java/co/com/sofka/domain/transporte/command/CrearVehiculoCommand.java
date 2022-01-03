package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.values.*;

public class CrearVehiculoCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdVehiculo idVehiculo;
    private final Placa placa;
    private final Conductor conductor;

    public CrearVehiculoCommand(
            IdTransporte idTransporte,
            IdVehiculo idVehiculo,
            Placa placa,
            Conductor conductor) {
        this.idTransporte = idTransporte;
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.conductor = conductor;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
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
