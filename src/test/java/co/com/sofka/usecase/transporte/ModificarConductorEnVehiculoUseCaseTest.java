package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.command.ModificarConductorEnVehiculoCommand;
import co.com.sofka.domain.transporte.events.ConductorEnVehiculoModificado;
import co.com.sofka.domain.transporte.events.ItemEnDocumentoDeEntregaAgregado;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarConductorEnVehiculoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarConductorEnVehiculo() {


        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdVehiculo idVehiculo = IdVehiculo.of("ccccc");
        Conductor conductor = new Conductor("Juvenal mesa");
        var command = new ModificarConductorEnVehiculoCommand(
                idTransporte,
                idVehiculo,
                conductor
        );

        var usecase = new ModificarConductorEnVehiculoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ConductorEnVehiculoModificado)events.get(0);

        Assertions.assertEquals("Juvenal mesa",event.getConductor().value());
        Mockito.verify(repository).getEventsBy("xxxxx");


    }

    private List<DomainEvent> events() {
        return List.of(
                new TransporteCreado(
                        IdAlistamiento.of("ddddd"),
                        new Fecha(new Date())
                ),
                new VehiculoCreado(
                        IdVehiculo.of("ccccc"),
                        new Placa("AAA123"),
                        new Conductor("Plutonio Uranio")
                )
        );
    }

}