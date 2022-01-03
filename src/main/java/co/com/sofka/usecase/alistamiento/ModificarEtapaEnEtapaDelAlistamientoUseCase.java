package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.ModificarEtapaEnEtapaDelAlistamiento;

public class ModificarEtapaEnEtapaDelAlistamientoUseCase extends
        UseCase<RequestCommand<ModificarEtapaEnEtapaDelAlistamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarEtapaEnEtapaDelAlistamiento> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(), retrieveEvents());
        alistamiento.modificarEtapaEnEtapaDelAlistamiento(
                command.getIdEtapaDelAlistamiento(),
                command.getFecha(),
                command.getEtapa()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
