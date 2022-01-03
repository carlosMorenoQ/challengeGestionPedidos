package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.ModificarPlacaVehiculoEnOrdenParaTransporte;

public class ModificarPlacaVehiculoEnOrdenParaTransporteUseCase extends
        UseCase<RequestCommand<ModificarPlacaVehiculoEnOrdenParaTransporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarPlacaVehiculoEnOrdenParaTransporte> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.modificarPlacaVehiculoEnOrdenParaTransporte(
                command.getIdOrdenParaTransporte(),
                command.getPlacaVehiculo()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
