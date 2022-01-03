package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.AgregarOrdenParaTransporte;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.OrdenParaTransporteAgregada;
import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.Codigo;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
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
class AgregarOrdenParaTransporteUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarOrdenParaTransporte() {

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdOrdenParaTransporte idOrdenParaTransporte = IdOrdenParaTransporte.of("ccccc");
        Codigo codigo = new Codigo(103654);
        DireccionEntrega direccionEntrega = new DireccionEntrega("Cr76 Cll 55-32");
        PlacaVehiculo placaVehiculo = new PlacaVehiculo("AAA123");
        Cliente cliente = new Cliente("Esteban", "Morales", 6068541, "1128455333");

        var command = new AgregarOrdenParaTransporte(
                idAlistamiento,
                idOrdenParaTransporte,
                codigo,
                direccionEntrega,
                placaVehiculo,
                cliente
        );

        var usecase = new AgregarOrdenParaTransporteUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (OrdenParaTransporteAgregada)events.get(0);

        Assertions.assertEquals(103654, event.getCodigo().value());
        Assertions.assertEquals("Cr76 Cll 55-32", event.getDireccionEntrega().value());
        Assertions.assertEquals("AAA123", event.getPlacaVehiculo().value());
        Assertions.assertEquals("Esteban", event.getCliente().value().nombres());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(new AlistamientoCreado(
                new Fecha(new Date())
        ));
    }

}