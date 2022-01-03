package co.com.sofka.domain.alistamiento.entity;

import co.com.sofka.domain.alistamiento.values.Etapa;
import co.com.sofka.domain.alistamiento.values.IdEtapaDelAlistamiento;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericValues.Fecha;

public class EtapaDelAlistamiento extends Entity<IdEtapaDelAlistamiento> {

    private final Fecha fechaInicial;
    private Fecha fechaEtapa;
    private Etapa etapa;

    public EtapaDelAlistamiento(
            IdEtapaDelAlistamiento entityId,
            Fecha fechaEtapa,
            Etapa etapa) {
        super(entityId);
        this.fechaInicial = fechaEtapa;
        this.fechaEtapa = fechaEtapa;
        this.etapa = etapa;
    }

    public Fecha fechaInicial() {
        return fechaInicial;
    }

    public Fecha fechaEtapa() {
        return fechaEtapa;
    }

    public Etapa estadoAlistamientoValue() {
        return etapa;
    }

    public void modificarEtapa(Etapa etapa, Fecha fecha){
        this.etapa =etapa;
        this.fechaEtapa = fecha;
    }


}
