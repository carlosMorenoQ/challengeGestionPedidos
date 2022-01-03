package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.ModificarDireccionEnOrdenParaTransporte;

public class ModificarDireccionEnOrdenParaTransporteUseCase extends
        UseCase<RequestCommand<ModificarDireccionEnOrdenParaTransporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarDireccionEnOrdenParaTransporte> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.modificarDireccionEnOrdenParaTransporte(
                command.getIdOrdenParaTransporte(),
                command.getDireccionEntrega()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
