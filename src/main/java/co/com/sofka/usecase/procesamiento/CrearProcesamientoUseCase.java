package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnPedidoCommand;
import co.com.sofka.domain.procesamiento.command.CrearProcesamientoCommand;

public class CrearProcesamientoUseCase extends
        UseCase<RequestCommand<CrearProcesamientoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProcesamientoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var procesamiento = new Procesamiento(
                command.getIdProcesamiento(),
                command.getFechaProcesamiento(),
                command.getProcesador()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
