package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.CrearOrdenParaAlistamientoCommand;

public class CrearOrdenParaAlistamientoUseCase extends
        UseCase<RequestCommand<CrearOrdenParaAlistamientoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOrdenParaAlistamientoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(),retrieveEvents());
        procesamiento.crearOrdenParaAlistamiento(
                command.getIdOrdenParaAlistamiento(),
                command.getCodigo(),
                command.getIdPedido(),
                command.getCliente(),
                command.getDireccionEntrega()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
