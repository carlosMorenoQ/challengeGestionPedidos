package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.*;
import co.com.sofka.domain.transporte.command.AgregarItemEnDocumentoDeEntregaCommand;
import co.com.sofka.domain.transporte.events.DocumentoDeEntregaCreado;
import co.com.sofka.domain.transporte.events.ItemEnDocumentoDeEntregaAgregado;
import co.com.sofka.domain.transporte.events.TransporteCreado;
import co.com.sofka.domain.transporte.events.VehiculoCreado;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;
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
class AgregarItemEnDocumentoDeEntregaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarItemEnDocumentoDeEntrega(){


        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdDocumentoDeEntrega idDocumentoDeEntrega = IdDocumentoDeEntrega.of("ccccc");
        Item item = new Item(new Descripcion("Cigarrillo Marlboro x10"), new Cantidad(40));

        var command = new AgregarItemEnDocumentoDeEntregaCommand(
                idTransporte,
                idDocumentoDeEntrega,
                item
        );

        var usecase = new AgregarItemEnDocumentoDeEntregaUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ItemEnDocumentoDeEntregaAgregado)events.get(0);

        Assertions.assertEquals("Cigarrillo Marlboro x10",event.getItem().value().descripcion().value());
        Assertions.assertEquals(40,event.getItem().value().cantidad().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new TransporteCreado(
                        IdAlistamiento.of("ddddd"),
                        new Fecha(new Date())
                ),
                new DocumentoDeEntregaCreado(
                        IdDocumentoDeEntrega.of("ccccc"),
                        new Codigo(12345),
                        new Cliente(
                                "Simon",
                                "Gonzalez",
                                60589654,
                                "1115554488"),
                        new DireccionEntrega("Clla 90 cra 56"),
                        new Fecha(new Date())
                )
        );
    }
}