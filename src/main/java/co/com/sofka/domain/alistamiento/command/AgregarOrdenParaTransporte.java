package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarOrdenParaTransporte extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdOrdenParaTransporte entityId;
    private final Codigo codigo;
    private final DireccionEntrega direccionEntrega;
    private final PlacaVehiculo placaVehiculo;
    private final Cliente cliente;

    public AgregarOrdenParaTransporte(
            IdAlistamiento idAlistamiento,
            IdOrdenParaTransporte entityId,
            Codigo codigo,
            DireccionEntrega direccionEntrega,
            PlacaVehiculo placaVehiculo,
            Cliente cliente) {
        this.idAlistamiento = idAlistamiento;
        this.entityId = entityId;
        this.codigo = codigo;
        this.direccionEntrega = direccionEntrega;
        this.placaVehiculo = placaVehiculo;
        this.cliente = cliente;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdOrdenParaTransporte getEntityId() {
        return entityId;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public PlacaVehiculo getPlacaVehiculo() {
        return placaVehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
