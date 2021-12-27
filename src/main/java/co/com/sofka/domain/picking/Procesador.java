package co.com.sofka.domain.picking;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.picking.values.Nombre;
import co.com.sofka.domain.picking.values.ProcesadorID;

public class Procesador extends Entity<ProcesadorID> {

    private Nombre nombre;

    public Procesador(ProcesadorID entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Procesador(ProcesadorID entityId) {
        super(entityId);
    }

    public Nombre Nombre() {
        return nombre;
    }


}
