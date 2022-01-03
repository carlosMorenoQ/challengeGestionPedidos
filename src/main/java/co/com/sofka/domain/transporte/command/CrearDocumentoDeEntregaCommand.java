package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.genericvalues.Cliente;
import co.com.sofka.domain.genericvalues.Codigo;
import co.com.sofka.domain.genericvalues.DireccionEntrega;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.transporte.values.IdDocumentoDeEntrega;
import co.com.sofka.domain.transporte.values.IdTransporte;

public class CrearDocumentoDeEntregaCommand extends Command {

    private final IdTransporte idTransporte;
    private final IdDocumentoDeEntrega idDocumentoDeEntrega;
    private final Codigo codigo;
    private final Cliente cliente;
    private final DireccionEntrega direccionEntrega;
    private final Fecha fechaCreacion;

    public CrearDocumentoDeEntregaCommand(
            IdTransporte idTransporte,
            IdDocumentoDeEntrega idDocumentoDeEntrega,
            Codigo codigo,
            Cliente cliente,
            DireccionEntrega direccionEntrega,
            Fecha fechaCreacion) {
        this.idTransporte = idTransporte;
        this.idDocumentoDeEntrega = idDocumentoDeEntrega;
        this.codigo = codigo;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaCreacion = fechaCreacion;
    }

    public IdTransporte getIdTransporte() {
        return idTransporte;
    }

    public IdDocumentoDeEntrega getIdDocumentoDeEntrega() {
        return idDocumentoDeEntrega;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }
}
