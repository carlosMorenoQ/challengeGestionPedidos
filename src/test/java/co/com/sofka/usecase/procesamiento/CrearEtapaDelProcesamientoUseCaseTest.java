package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.command.CrearEtapaDelProcesamientoCommand;
import co.com.sofka.domain.procesamiento.events.EtapaDelProcesamientoCreada;
import co.com.sofka.domain.procesamiento.events.ProcesamientoCreado;
import co.com.sofka.domain.procesamiento.values.Etapa;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.values.IdProcesamiento;
import co.com.sofka.domain.procesamiento.values.Procesador;
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
class CrearEtapaDelProcesamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearEtapaDelProcesamiento(){


        IdProcesamiento idProcesamiento = IdProcesamiento.of("xxxxx");
        IdEtapaDelProcesamiento idEtapaDelProcesamiento = IdEtapaDelProcesamiento.of("ccccc");
        Fecha fecha = new Fecha(new Date());
        Etapa etapa = new Etapa("Procesamiento pendiente");
        var command = new CrearEtapaDelProcesamientoCommand(
                idProcesamiento,
                idEtapaDelProcesamiento,
                fecha,
                etapa
        );

        var usecase = new CrearEtapaDelProcesamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcesamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event  = (EtapaDelProcesamientoCreada)events.get(0);

        Assertions.assertEquals("Procesamiento pendiente",event.getEtapa().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new ProcesamientoCreado(
                        new Fecha(new Date()),
                        new Procesador("Estrella", "Estivia")
                )
        );
    }

}