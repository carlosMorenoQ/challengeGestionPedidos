package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.command.CrearVehiculoCommand;
import co.com.sofka.domain.transporte.events.TransporteCreado;
import co.com.sofka.domain.transporte.events.VehiculoCreado;
import co.com.sofka.domain.transporte.values.Conductor;
import co.com.sofka.domain.transporte.values.IdTransporte;
import co.com.sofka.domain.transporte.values.IdVehiculo;
import co.com.sofka.domain.transporte.values.Placa;
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
class CrearVehiculoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearVehiculo(){

        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdVehiculo idVehiculo = IdVehiculo.of("ccccc");
        Placa placa = new Placa("AAA123");
        Conductor conductor = new Conductor("Sebastian");
        var command = new CrearVehiculoCommand(
                idTransporte,
                idVehiculo,
                placa,
                conductor
        );

        var usecase = new CrearVehiculoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VehiculoCreado)events.get(0);

        Assertions.assertEquals("AAA123", event.getPlaca().value());
        Assertions.assertEquals("Sebastian", event.getConductor().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new TransporteCreado(
                        IdAlistamiento.of("ddddd"),
                        new Fecha(new Date())
                )
        );
    }

}