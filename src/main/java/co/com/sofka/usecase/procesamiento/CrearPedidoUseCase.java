package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procesamiento.Procesamiento;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnPedidoCommand;
import co.com.sofka.domain.procesamiento.command.CrearPedidoCommand;

public class CrearPedidoUseCase extends
        UseCase<RequestCommand<CrearPedidoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedidoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var procesamiento = Procesamiento.from(command.getIdProcesamiento(), retrieveEvents());
        procesamiento.crearPedido(
                command.getIdPedido(),
                command.getConsecutivo(),
                command.getCliente(),
                command.getDireccionEntrega()
        );
        emit().onResponse(new ResponseEvents(procesamiento.getUncommittedChanges()));
    }
}
