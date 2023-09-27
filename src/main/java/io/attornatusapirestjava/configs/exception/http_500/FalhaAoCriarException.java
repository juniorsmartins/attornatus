package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoCriarException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoCriarException(String message) {
        super(message);
    }
}

