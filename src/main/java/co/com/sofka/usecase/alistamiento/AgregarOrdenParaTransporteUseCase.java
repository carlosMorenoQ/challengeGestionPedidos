package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.alistamiento.Alistamiento;
import co.com.sofka.domain.alistamiento.command.AgregarOrdenParaTransporte;

public class AgregarOrdenParaTransporteUseCase extends UseCase<RequestCommand<AgregarOrdenParaTransporte>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarOrdenParaTransporte> requestCommand) {
        var command = requestCommand.getCommand();
        var alistamiento= Alistamiento.from(command.getIdAlistamiento(),retrieveEvents());
        alistamiento.agregarOrdenParaTransporte(
                command.getEntityId(),
                command.getCodigo(),
                command.getDireccionEntrega(),
                command.getPlacaVehiculo(),
                command.getCliente()
        );

        emit().onResponse(new ResponseEvents(alistamiento.getUncommittedChanges()));

    }
}
