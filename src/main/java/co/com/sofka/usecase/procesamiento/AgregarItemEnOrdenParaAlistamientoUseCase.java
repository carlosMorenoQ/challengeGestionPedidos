package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnOrdenParaAlistamientoCommand;

public class AgregarItemEnOrdenParaAlistamientoUseCase extends
        UseCase<RequestCommand<AgregarItemEnOrdenParaAlistamientoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarItemEnOrdenParaAlistamientoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(),retrieveEvents());
        procesamiento.agregarItemEnOrdenParaAlistamiento(
                command.getIdOrdenParaAlistamiento(),
                command.getItem()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
