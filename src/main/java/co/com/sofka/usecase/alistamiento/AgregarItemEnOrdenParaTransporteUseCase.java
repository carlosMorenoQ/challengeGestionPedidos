package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.AgregarItemEnOrdenParaTransporte;

public class AgregarItemEnOrdenParaTransporteUseCase extends
        UseCase<RequestCommand<AgregarItemEnOrdenParaTransporte>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarItemEnOrdenParaTransporte> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.agregarItemEnOrdenParaTransporte(
                command.getIdOrdenParaTransporte(),
                command.getItem()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
