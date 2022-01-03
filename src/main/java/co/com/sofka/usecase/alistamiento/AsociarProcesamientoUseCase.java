package co.com.sofka.usecase.alistamiento;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.AsociarProcesamiento;

public class AsociarProcesamientoUseCase extends UseCase<RequestCommand<AsociarProcesamiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarProcesamiento> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(), retrieveEvents());
        alistamiento.asociarProcesamiento(
                command.getIdProcesamiento()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }

}
