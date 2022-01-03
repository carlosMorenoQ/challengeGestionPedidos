package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.command.CrearTransporteCommand;
import co.com.sofka.domain.transporte.events.TransporteCreado;
import co.com.sofka.domain.transporte.values.IdTransporte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearTransporteUseCaseTest {

    @Test
    void crearTransporte(){

        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdAlistamiento idAlistamiento = IdAlistamiento.of("ccccc");
        Fecha fechaTransporte = new Fecha(new Date());
        var command = new CrearTransporteCommand(
                idTransporte,
                idAlistamiento,
                fechaTransporte
        );

        var usecase = new CrearTransporteUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow();

        TransporteCreado event = (TransporteCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxxx", event.aggregateRootId());

    }

}