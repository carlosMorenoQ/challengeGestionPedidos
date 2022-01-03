package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.CrearEtapaDelProcesamientoCommand;

public class CrearEtapaDelProcesamientoUseCase extends
        UseCase<RequestCommand<CrearEtapaDelProcesamientoCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEtapaDelProcesamientoCommand> requestCommand) {

        var command = requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(),retrieveEvents());
        procesamiento.crearEtapaDelProcesamiento(
                command.getIdEtapaDelProcesamiento(),
                command.getFecha(),
                command.getEtapa()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
