package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.ModificarClienteEnOrdeParaTransporte;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.ClienteEnOrdeParaTransporteModificado;
import co.com.sofka.domain.alistamiento.events.OrdenParaTransporteAgregada;
import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericValues.Fecha;
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
class ModificarClienteEnOrdeParaTransporteUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarClienteEnOrdeParaTransporte(){

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdOrdenParaTransporte idOrdenParaTransporte = IdOrdenParaTransporte.of("ccccc");
        Cliente cliente = new Cliente("Pedro","Gonzalez", 6048094, "1128455333");
        var command = new ModificarClienteEnOrdeParaTransporte(
                idAlistamiento,
                idOrdenParaTransporte,
                cliente
        );

        var usecase = new ModificarClienteEnOrdeParaTransporteUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClienteEnOrdeParaTransporteModificado)events.get(0);

        Assertions.assertEquals("Pedro",event.getCliente().value().nombres());
        Assertions.assertEquals("Gonzalez",event.getCliente().value().apellidos());
        Assertions.assertEquals(6048094,event.getCliente().value().telefono());
        Assertions.assertEquals("1128455333",event.getCliente().value().documentoIdentificacion());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new AlistamientoCreado(
                        new Fecha(new Date())),
                new OrdenParaTransporteAgregada(
                        IdOrdenParaTransporte.of("xxxx"),
                        new Codigo(103654),
                        new DireccionEntrega("Cr76 Cll 55-32"),
                        new PlacaVehiculo("AAA123"),
                        new Cliente(
                                "Esteban",
                                "Morales",
                                6068541,
                                "1128455333")));
    }

}