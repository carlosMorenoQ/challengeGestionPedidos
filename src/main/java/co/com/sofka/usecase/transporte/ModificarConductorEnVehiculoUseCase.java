package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.ModificarConductorEnVehiculoCommand;

public class ModificarConductorEnVehiculoUseCase extends
        UseCase<RequestCommand<ModificarConductorEnVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarConductorEnVehiculoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
        transporte.modificarConductorEnVehiculo(
                command.getIdVehiculo(),
                command.getConductor()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
