package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.CrearAlistamiento;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.genericValues.Fecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearAlistamientoUseCaseTest {

    @Test
    public void crearAlistamiento(){

        //arrange
        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxxx");
        Fecha fechaAlistamiento = new Fecha(new Date());
        var command = new CrearAlistamiento(idAlistamiento,fechaAlistamiento);
        var usecase = new CrearAlistamientoUseCase();

        //act
        var events =UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asert
        AlistamientoCreado event = (AlistamientoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxxxx",event.aggregateRootId());
    }

}