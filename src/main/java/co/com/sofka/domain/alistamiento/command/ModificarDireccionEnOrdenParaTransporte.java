package co.com.sofka.domain.alistamiento.command;

import co.com.sofka.domain.alistamiento.values.IdAlistamiento;
import co.com.sofka.domain.alistamiento.values.IdOrdenParaTransporte;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.DireccionEntrega;

public class ModificarDireccionEnOrdenParaTransporte extends Command {

    private final IdAlistamiento idAlistamiento;
    private final IdOrdenParaTransporte idOrdenParaTransporte;
    private final DireccionEntrega direccionEntrega;

    public ModificarDireccionEnOrdenParaTransporte(
            IdAlistamiento idAlistamiento,
            IdOrdenParaTransporte idOrdenParaTransporte,
            DireccionEntrega direccionEntrega) {
        this.idAlistamiento = idAlistamiento;
        this.idOrdenParaTransporte = idOrdenParaTransporte;
        this.direccionEntrega = direccionEntrega;
    }

    public IdAlistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public IdOrdenParaTransporte getIdOrdenParaTransporte() {
        return idOrdenParaTransporte;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

}
