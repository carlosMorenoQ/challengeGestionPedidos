package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.ModificarEtapaEnEtapaDelAlistamiento;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.EtapaDelAlistamientoAgregada;
import co.com.sofka.domain.alistamiento.events.EtapaEnEtapaDelAlistamientoModificada;
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
class ModificarEtapaEnEtapaDelAlistamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarEtapaEnEtapaDelAlistamiento() {

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdEtapaDelAlistamiento idEtapaDelAlistamiento = IdEtapaDelAlistamiento.of("ccccc");
        Fecha fecha = new Fecha(new Date());
        Etapa etapa = new Etapa("finalizado");

        var command = new ModificarEtapaEnEtapaDelAlistamiento(
                idAlistamiento,
                idEtapaDelAlistamiento,
                fecha,
                etapa
        );

        var usecase = new ModificarEtapaEnEtapaDelAlistamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EtapaEnEtapaDelAlistamientoModificada) events.get(0);

        Assertions.assertEquals("finalizado", event.getEtapa().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> events() {
        return List.of(
                new AlistamientoCreado(
                        new Fecha(new Date())),
                new EtapaDelAlistamientoAgregada(
                        IdEtapaDelAlistamiento.of("ccccc"),
                        new Fecha(new Date()),
                        new Etapa("en preparacion")));
    }

}