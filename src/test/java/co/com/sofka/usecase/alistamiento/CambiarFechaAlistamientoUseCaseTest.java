package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.CambiarFechaAlistamiento;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.FechaAlistamientoCambiada;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarFechaAlistamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarFechaAlistamiento(){

        Date date = new Date();
        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        Fecha fechaAlistamiento = new Fecha(date);

        var command = new CambiarFechaAlistamiento(
                idAlistamiento,
                fechaAlistamiento
        );

        var usecase = new CambiarFechaAlistamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FechaAlistamientoCambiada)events.get(0);

        Assertions.assertEquals(date,event.getFechaAlistamiento().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(new AlistamientoCreado(
                new Fecha(new Date())
        ));
    }

}