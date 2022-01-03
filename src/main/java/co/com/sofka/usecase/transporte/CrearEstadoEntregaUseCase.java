package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.CrearEstadoEntregaCommand;

public class CrearEstadoEntregaUseCase extends
        UseCase<RequestCommand<CrearEstadoEntregaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEstadoEntregaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
        transporte.crearEstadoEntrega(
                command.getIdEstadoDeEntrega(),
                command.getFechaEstado(),
                command.getEstado()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
