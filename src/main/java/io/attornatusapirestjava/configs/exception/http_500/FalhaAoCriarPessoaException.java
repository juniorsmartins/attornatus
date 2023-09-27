package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoCriarPessoaException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoCriarPessoaException(String message) {
        super(message);
    }
}

