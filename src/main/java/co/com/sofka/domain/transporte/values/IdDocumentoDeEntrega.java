package co.com.sofka.domain.transporte.values;

import co.com.sofka.domain.generic.Identity;

public class IdDocumentoDeEntrega extends Identity {

    public IdDocumentoDeEntrega(String uuid) {
        super(uuid);
    }

    public IdDocumentoDeEntrega() {
    }

    public static IdDocumentoDeEntrega of(String uuid){
        return new IdDocumentoDeEntrega(uuid);
    }
}
