package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.AgregarItemEnDocumentoDeEntregaCommand;
import co.com.sofka.domain.transporte.command.CrearVehiculoCommand;

public class CrearVehiculoUseCase extends
        UseCase<RequestCommand<CrearVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVehiculoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
        transporte.crearVehiculo(
                command.getIdVehiculo(),
                command.getPlaca(),
                command.getConductor()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
