package co.com.sofka.usecase.procesamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.command.CrearOrdenParaAlistamientoCommand;
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
class CrearOrdenParaAlistamientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearOrdenParaAlistamiento(){


        IdProcesamiento idProcesamiento = IdProcesamiento.of("xxxxx");
        IdOrdenParaAlistamiento idOrdenParaAlistamiento = IdOrdenParaAlistamiento.of("ccccc");
        String codigo = "OP003";
        IdPedido idPedido = IdPedido.of("ddddd");
        Cliente cliente = new Cliente(
                "Felipe",
                "Albert",
                6084251,
                "1128455300");
        DireccionEntrega direccionEntrega = new DireccionEntrega("Cll80 Cr80-21");
        var command = new CrearOrdenParaAlistamientoCommand(
                idProcesamiento,
                idOrdenParaAlistamiento,
                codigo,
                idPedido,
                cliente,
                direccionEntrega
        );

        var usecase = new CrearOrdenParaAlistamientoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcesamiento.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event  = (OrdenParaAlistamientoCreada)events.get(0);

        Assertions.assertEquals("OP003",event.getCodigo());
        Assertions.assertEquals("Felipe",event.getCliente().value().nombres());
        Assertions.assertEquals("Cll80 Cr80-21",event.getDireccionEntrega().value());
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