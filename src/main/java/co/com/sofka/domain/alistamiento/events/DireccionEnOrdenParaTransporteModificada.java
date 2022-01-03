package co.com.sofka.domain.alistamiento.events;

import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.genericvalues.DireccionEntrega;

public class DireccionEnOrdenParaTransporteModificada extends DomainEvent {

    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final DireccionEntrega direccionEntrega;

    public DireccionEnOrdenParaTransporteModificada(
            IdOrdenParaTransporte idOrdenParaTransporte,
            DireccionEntrega direccionEntrega) {
        super("sofka.alistamiento.direccionEnOrdenParaTransporteModificada");
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.direccionEntrega = direccionEntrega;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }
}
