package co.com.sofka.usecase.transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.Codigo;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.command.CrearDocumentoDeEntregaCommand;
import co.com.sofka.domain.transporte.events.DocumentoDeEntregaCreado;
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
class CrearDocumentoDeEntregaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearDocumentoDeEntrega(){

        IdTransporte idTransporte = IdTransporte.of("xxxxx");
        IdDocumentoDeEntrega idDocumentoDeEntrega = IdDocumentoDeEntrega.of("ccccc");
        Codigo codigo = new Codigo(190);
        Cliente cliente = new Cliente(
                "Gabriel",
                "Rodriguez",
                6059832,
                "1128455333");
        DireccionEntrega direccionEntrega = new DireccionEntrega("Cll90 Cra 32-80");
        Fecha fechaCreacion = new Fecha(new Date());
        var command = new CrearDocumentoDeEntregaCommand(
                idTransporte,
                idDocumentoDeEntrega,
                codigo,
                cliente,
                direccionEntrega,
                fechaCreacion
        );

        var usecase = new CrearDocumentoDeEntregaUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idTransporte.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DocumentoDeEntregaCreado)events.get(0);

        Assertions.assertEquals(190, event.getCodigo().value());
        Assertions.assertEquals("Gabriel", event.getCliente().value().nombres());
        Assertions.assertEquals("Cll90 Cra 32-80", event.getDireccionEntrega().value());
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