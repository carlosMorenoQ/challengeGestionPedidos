package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.CrearAlistamiento;

public class CrearAlistamientoUseCase extends UseCase<RequestCommand<CrearAlistamiento>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearAlistamiento> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = new Alistamiento(
                command.getIdAlistamiento(),
                command.getFechaAlistamiento());
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }

}
