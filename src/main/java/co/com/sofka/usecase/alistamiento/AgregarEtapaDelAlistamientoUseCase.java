package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.AgregarEtapaDelAlistamiento;
import co.com.sofka.domain.alistamiento.entity.EtapaDelAlistamiento;

public class AgregarEtapaDelAlistamientoUseCase extends UseCase<RequestCommand<AgregarEtapaDelAlistamiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEtapaDelAlistamiento> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.agregarEtapaDelAlistamiento(
                command.getIdEtapaDelAlistamiento(),
                command.getFechaEtapa(),
                command.getEtapa()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }

}
