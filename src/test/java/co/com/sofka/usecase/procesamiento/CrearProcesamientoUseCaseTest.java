package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.command.CrearProcesamientoCommand;
import co.com.sofka.domain.procesamiento.events.ProcesamientoCreado;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;
import co.com.sofka.domain.procesamiento.values.Procesador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


class CrearProcesamientoUseCaseTest {

    @Test
    void crearProcesamiento() {

        //arrange
        IdProcesamiento idProcesamiento = IdProcesamiento.of("xxxxx");
        Fecha fechaProcesamiento = new Fecha(new Date());
        Procesador procesador = new Procesador("carlos", "moreno");
        var command = new CrearProcesamientoCommand(
                idProcesamiento,
                fechaProcesamiento,
                procesador
        );

        var usecase = new CrearProcesamientoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow();

        //assert
        ProcesamientoCreado event = (ProcesamientoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxxx",event.aggregateRootId());

    }



}