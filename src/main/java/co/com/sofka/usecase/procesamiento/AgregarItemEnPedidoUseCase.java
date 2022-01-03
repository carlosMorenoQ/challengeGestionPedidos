package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnPedidoCommand;

public class AgregarItemEnPedidoUseCase extends
        UseCase<RequestCommand<AgregarItemEnPedidoCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarItemEnPedidoCommand> requestCommand) {
        var command= requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(), retrieveEvents());
        procesamiento.agregarItemEnPedido(
                command.getIdPedido(),
                command.getItem()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
