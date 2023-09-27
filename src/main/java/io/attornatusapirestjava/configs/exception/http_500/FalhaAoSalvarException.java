package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoSalvarException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoSalvarException(String message) {
        super(message);
    }

    public FalhaAoSalvarException() {
        this("Falha ao salvar uma pessoa.");
    }
}

