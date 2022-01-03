package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.values.Conductor;
import co.com.sofka.domain.transporte.values.IdTransporte;
import co.com.sofka.domain.transporte.values.IdVehiculo;

public class ModificarConductorEnVehiculoCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdVehiculo idVehiculo;
    private final Conductor conductor;

    public ModificarConductorEnVehiculoCommand(
            IdTransporte idTransporte,
            IdVehiculo idVehiculo,
            Conductor conductor) {
        this.idTransporte = idTransporte;
        this.idVehiculo = idVehiculo;
        this.conductor = conductor;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdVehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }
}
