package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.alistamiento.values.PlacaVehiculo;
import co.com.sofka.domain.generic.Command;

public class ModificarPlacaVehiculoEnOrdenParaTransporte extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private  final PlacaVehiculo placaVehiculo;

    public ModificarPlacaVehiculoEnOrdenParaTransporte(
            IdAlistamiento idAlistamiento,
            IdOrdenParaTransporte idOrdenParaTransporte,
            PlacaVehiculo placaVehiculo) {
        this.idAlistamiento = idAlistamiento;
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.placaVehiculo = placaVehiculo;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public PlacaVehiculo getPlacaVehiculo() {
        return placaVehiculo;
    }
}
