package co.com.sofka.usecase.alistamiento;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.CambiarFechaAlistamiento;

public class CambiarFechaAlistamientoUseCase extends UseCase<RequestCommand<CambiarFechaAlistamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarFechaAlistamiento> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.cambiarFechaAlistamiento(
                command.getFechaAlistamiento()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
