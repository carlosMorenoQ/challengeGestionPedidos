package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.AgregarEtapaDelAlistamiento;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.EtapaDelAlistamientoAgregada;
import co.com.sofka.domain.alistamiento.values.Etapa;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.alistamiento.values.IdEtapaDelAlistamiento;
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
class AgregarEtapaDelAlistamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEtapaDelAlistamiento() {

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdEtapaDelAlistamiento idEtapaDelAlistamiento = IdEtapaDelAlistamiento.of("ccccc");
        Fecha fechaEtapa = new Fecha(new Date());
        Etapa etapa = new Etapa("en preparacion");

        var command = new AgregarEtapaDelAlistamiento(
                idAlistamiento,
                idEtapaDelAlistamiento,
                fechaEtapa,
                etapa
        );

        var usecase = new AgregarEtapaDelAlistamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EtapaDelAlistamientoAgregada)events.get(0);

        Assertions.assertEquals("en preparacion", event.getEtapa().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(new AlistamientoCreado(
                new Fecha(new Date())
        ));
    }
}