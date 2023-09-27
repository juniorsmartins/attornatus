package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoConsultarPessoaException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoConsultarPessoaException(String message) {
        super(message);
    }
}

