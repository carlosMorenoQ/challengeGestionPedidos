package co.com.sofka.domain.procesamiento;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.procesamiento.events.*;

public class ProcesamientoChange extends EventChange {

    public ProcesamientoChange(Procesamiento procesamiento) {

        apply((ProcesamientoCreado event) -> {
        });

    }
}
