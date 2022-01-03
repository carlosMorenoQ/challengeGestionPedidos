package co.com.sofka.usecase.alistamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.command.ModificarDireccionEnOrdenParaTransporte;
import co.com.sofka.domain.alistamiento.events.AlistamientoCreado;
import co.com.sofka.domain.alistamiento.events.DireccionEnOrdenParaTransporteModificada;
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
class ModificarDireccionEnOrdenParaTransporteUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarDireccionEnOrdenParaTransporte(){

        IdAlistamiento idAlistamiento = IdAlistamiento.of("xxxxx");
        IdOrdenParaTransporte idOrdenParaTransporte = IdOrdenParaTransporte.of("ccccc");
        DireccionEntrega direccionEntrega = new DireccionEntrega("Cll 49 Cr 12-11");

        var command = new ModificarDireccionEnOrdenParaTransporte(
                idAlistamiento,
                idOrdenParaTransporte,
                direccionEntrega
        );

        var usecase = new ModificarDireccionEnOrdenParaTransporteUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAlistamiento.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DireccionEnOrdenParaTransporteModificada)events.get(0);

        Assertions.assertEquals("Cll 49 Cr 12-11",event.getDireccionEntrega().value());
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