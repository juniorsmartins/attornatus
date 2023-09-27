package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoConsultarException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoConsultarException(String message) {
        super(message);
    }
}

