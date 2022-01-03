package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.AsociarProcesamiento;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.ProcesamientoAsociado;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsociarProcesamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asociarProcesamiento(){

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdProcesamiento idProcesamiento = IdProcesamiento.of("ccccc");
        var command = new AsociarProcesamiento(
                idAlistamiento,
                idProcesamiento
        );

        var usecase = new AsociarProcesamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProcesamientoAsociado)events.get(0);

        Assertions.assertEquals(IdProcesamiento.of("ccccc").value(),event.getIdProcesamiento().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(new AlistamientoCreado(
                new Fecha(new Date())
        ));
    }


}