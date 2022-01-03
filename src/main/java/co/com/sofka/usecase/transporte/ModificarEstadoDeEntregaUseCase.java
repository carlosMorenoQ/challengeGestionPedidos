package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.ModificarEstadoDeEntregaCommand;

public class ModificarEstadoDeEntregaUseCase extends
        UseCase<RequestCommand<ModificarEstadoDeEntregaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarEstadoDeEntregaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
        transporte.modificarEstadoDeEntrega(
                command.getIdEstadoDeEntrega(),
                command.getEstado()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
