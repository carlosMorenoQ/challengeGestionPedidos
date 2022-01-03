package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.AgregarItemEnDocumentoDeEntregaCommand;

public class AgregarItemEnDocumentoDeEntregaUseCase extends
        UseCase<RequestCommand<AgregarItemEnDocumentoDeEntregaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarItemEnDocumentoDeEntregaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
        transporte.agregarItemEnDocumentoDeEntrega(
                command.getIdDocumentoDeEntrega(),
                command.getItem()
        );
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
