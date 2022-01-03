package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.ModificarClienteEnOrdeParaTransporte;

public class ModificarClienteEnOrdeParaTransporteUseCase extends
        UseCase<RequestCommand<ModificarClienteEnOrdeParaTransporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarClienteEnOrdeParaTransporte> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento = Alistamiento.from(command.getIdAlistamiento(), retrieveEvents());
        alistamiento.modificarClienteEnOrdeParaTransporte(
                command.getIdOrdenParaTransporte(),
                command.getCliente()
        );
        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));
    }
}
