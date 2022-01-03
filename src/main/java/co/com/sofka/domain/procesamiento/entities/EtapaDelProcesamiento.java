package co.com.sofka.domain.procesamiento.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.genericvalues.Fecha;
import co.com.sofka.domain.procesamiento.values.IdEtapaDelProcesamiento;
import co.com.sofka.domain.procesamiento.values.Etapa;

public class EtapaDelProcesamiento extends Entity<IdEtapaDelProcesamiento> {

    private Fecha fecha;
    private Etapa etapa;


    public EtapaDelProcesamiento(
            IdEtapaDelProcesamiento idEtapaDelProcesamiento,
            Fecha fecha,
            Etapa etapa) {
        super(idEtapaDelProcesamiento);
        this.fecha = fecha;
        this.etapa = etapa;
    }


    public void modificarEstadoProcesamiento(
            Etapa etapa){
        this.etapa = etapa;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Etapa etapa  () {
        return etapa;
    }

}
