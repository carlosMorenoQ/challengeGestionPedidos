package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.alistamiento.values.PlacaVehiculo;
import co.com.sofka.domain.generic.DomainEvent;

public class PlacaVehiculoEnOrdenParaTransporteModificada extends DomainEvent {

    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final PlacaVehiculo placaVehiculo;

    public PlacaVehiculoEnOrdenParaTransporteModificada(
            IdOrdenParaTransporte idOrdenParaTransporte,
            PlacaVehiculo placaVehiculo) {
        super("sofka.alistamiento.placaVehiculoEnOrdenParaTransporteModificada");
        this.idOrdenParaTransporte=idOrdenParaTransporte;
        this.placaVehiculo = placaVehiculo;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public PlacaVehiculo getPlacaVehiculo() {
        return placaVehiculo;
    }
}
