package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoEditarPessoaException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoEditarPessoaException(String message) {
        super(message);
    }

    public FalhaAoEditarPessoaException() {
        this("Falha ao editar uma pessoa.");
    }
}

