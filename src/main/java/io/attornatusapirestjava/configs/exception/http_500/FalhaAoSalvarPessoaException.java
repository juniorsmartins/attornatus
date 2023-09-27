package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoSalvarPessoaException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoSalvarPessoaException(String message) {
        super(message);
    }

    public FalhaAoSalvarPessoaException() {
        this("Falha ao salvar uma pessoa.");
    }
}

