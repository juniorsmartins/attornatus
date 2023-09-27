package io.attornatusapirestjava.configs.exception.http500;

import java.io.Serial;

public final class FalhaAoSalvarException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoSalvarException(String message) {
        super(message);
    }
}

