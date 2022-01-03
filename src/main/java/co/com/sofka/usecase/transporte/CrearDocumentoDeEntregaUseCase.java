package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.transporte.Transporte;
import co.com.sofka.domain.transporte.command.CrearDocumentoDeEntregaCommand;

public class CrearDocumentoDeEntregaUseCase extends
        UseCase<RequestCommand<CrearDocumentoDeEntregaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearDocumentoDeEntregaCommand> requestCommand) {
            var command = requestCommand.getCommand();
            var transporte = Transporte.from(command.getIdTransporte(),retrieveEvents());
            transporte.crearDocumentoDeEntrega(
                    command.getIdDocumentoDeEntrega(),
                    command.getCodigo(),
                    command.getCliente(),
                    command.getDireccionEntrega(),
                    command.getFechaCreacion()
            );
            emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
