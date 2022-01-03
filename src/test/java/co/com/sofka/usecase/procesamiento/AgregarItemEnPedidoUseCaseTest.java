package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.*;
import co.com.sofka.domain.procesamiento.command.AgregarItemEnPedidoCommand;
import co.com.sofka.domain.procesamiento.events.ItemEnPedidoAgregado;
import co.com.sofka.domain.procesamiento.events.OrdenParaAlistamientoCreada;
import co.com.sofka.domain.procesamiento.events.ProcesamientoCreado;
import co.com.sofka.domain.procesamiento.values.*;
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
class AgregarItemEnPedidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarItemEnPedido() {

        IdProcesamiento idProcesamiento = IdProcesamiento.of("xxxxx");
        IdPedido idPedido = IdPedido.of("ccccc");
        Descripcion descripcion = new Descripcion("Cigarrillo Marlboro x10");
        Cantidad cantidad = new Cantidad(15);
        Item item = new Item(descripcion, cantidad);
        var command = new AgregarItemEnPedidoCommand(
                idProcesamiento,
                idPedido,
                item
        );

        var usecase = new AgregarItemEnPedidoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcesamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event  = (ItemEnPedidoAgregado)events.get(0);

        Assertions.assertEquals("Cigarrillo Marlboro x10",event.getItem().value().descripcion().value());
        Assertions.assertEquals(15,event.getItem().value().cantidad().value());
        Mockito.verify(repository).getEventsBy("xxxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new ProcesamientoCreado(
                        new Fecha(new Date()),
                        new Procesador("Estrella", "Estivia")),
                new OrdenParaAlistamientoCreada(
                        IdOrdenParaAlistamiento.of("ccccc"),
                        "OP005",
                        IdPedido.of("ddddd"),
                        new Cliente(
                                "Juan",
                                "Albarracin",
                                6058912,
                                "114596324"),
                        new DireccionEntrega("Cll80 Cra80")                )
        );
    }

}