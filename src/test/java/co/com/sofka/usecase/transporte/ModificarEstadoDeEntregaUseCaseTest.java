package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.command.ModificarEstadoDeEntregaCommand;
import co.com.sofka.domain.transporte.events.EstadoDeEntregaModificado;
import co.com.sofka.domain.transporte.events.ItemEnDocumentoDeEntregaAgregado;
import co.com.sofka.domain.transporte.events.TransporteCreado;
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
class ModificarEstadoDeEntregaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarEstadoDeEntrega(){

        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdEstadoDeEntrega idEstadoDeEntrega = IdEstadoDeEntrega.of("ccccc");
        Estado estado = new Estado("Pedido Entregado");
        var command = new ModificarEstadoDeEntregaCommand(
                idTransporte,
                idEstadoDeEntrega,
                estado
        );

        var usecase = new ModificarEstadoDeEntregaUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EstadoDeEntregaModificado)events.get(0);


        Assertions.assertEquals("Pedido Entregado",event.getEstado().value());
        Mockito.verify(repository).getEventsBy("xxxxx");


    }

    private List<DomainEvent> events() {
        return List.of(
                new TransporteCreado(
                        IdAlistamiento.of("ddddd"),
                        new Fecha(new Date())
                ),
                new EstadoDeEntregaModificado(
                        IdEstadoDeEntrega.of("ccccc"),
                        new Estado("Entrega en proceso")
                )
        );
    }


}