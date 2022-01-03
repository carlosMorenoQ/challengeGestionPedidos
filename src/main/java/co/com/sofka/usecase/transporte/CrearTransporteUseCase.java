package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.command.CrearProcesamientoCommand;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.AgregarItemEnDocumentoDeEntregaCommand;
import co.com.sofka.domain.transporte.command.CrearTransporteCommand;

public class CrearTransporteUseCase extends
        UseCase<RequestCommand<CrearTransporteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTransporteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = new Transporte(
                command.getIdTransporte(),
                command.getIdAlistamiento(),
                command.getFechaTransporte()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
