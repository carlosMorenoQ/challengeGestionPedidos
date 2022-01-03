package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.command.CrearPedidoCommand;
import co.com.sofka.domain.procesamiento.events.PedidoCreado;
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
class CrearPedidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearPedido(){

        IdProcesamiento idProcesamiento = IdProcesamiento.of("xxxxx");
        IdPedido idPedido = IdPedido.of("ccccc");
        Consecutivo consecutivo = new Consecutivo(101);
        Cliente cliente = new Cliente(
                "Carlos",
                "Moreno",
                6058365,
                "1128455300");
        DireccionEntrega direccionEntrega = new DireccionEntrega("Cll40 Cr45-98");

        var command = new CrearPedidoCommand(
                idProcesamiento,
                idPedido,
                consecutivo,
                cliente,
                direccionEntrega
        );

        var usecase = new CrearPedidoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcesamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event  = (PedidoCreado)events.get(0);

        Assertions.assertEquals(101,event.getConsecutivo().value());
        Assertions.assertEquals("Carlos",event.getCliente().value().nombres());
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