package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.events.PedidoCreado;
import co.com.sofka.domain.procesamiento.events.ProcesamientoCreado;
import co.com.sofka.domain.procesamiento.values.Procesador;
import co.com.sofka.domain.transporte.command.CrearEstadoEntregaCommand;
import co.com.sofka.domain.transporte.events.EstadoEntregaCreado;
import co.com.sofka.domain.transporte.values.Estado;
import co.com.sofka.domain.transporte.values.IdEstadoDeEntrega;
import co.com.sofka.domain.transporte.values.IdTransporte;
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
class CrearEstadoEntregaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearEstadoEntrega(){


        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdEstadoDeEntrega idEstadoDeEntrega = IdEstadoDeEntrega.of("ccccc");
        Fecha fechEstado = new Fecha(new Date());
        Estado estado = new Estado("Transporte en curso");
        var command = new CrearEstadoEntregaCommand(
                idTransporte,
                idEstadoDeEntrega,
                fechEstado,
                estado
        );


        var usecase = new CrearEstadoEntregaUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event  = (EstadoEntregaCreado)events.get(0);

        Assertions.assertEquals("Transporte en curso",event.getEstado().value());
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