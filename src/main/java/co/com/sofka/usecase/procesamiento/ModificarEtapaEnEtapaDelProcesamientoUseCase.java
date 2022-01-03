package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnPedidoCommand;
import co.com.sofka.domain.procesamiento.command.ModificarEtapaEnEtapaDelProcesamientoCommand;

public class ModificarEtapaEnEtapaDelProcesamientoUseCase extends
        UseCase<RequestCommand<ModificarEtapaEnEtapaDelProcesamientoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarEtapaEnEtapaDelProcesamientoCommand> requestCommand) {
        var command= requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(), retrieveEvents());
        procesamiento.modificarEtapaEnEtapaDelProcesamiento(
                command.getIdEtapaDelProcesamiento(),
                command.getEtapa()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
