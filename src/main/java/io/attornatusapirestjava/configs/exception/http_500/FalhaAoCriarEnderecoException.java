package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoCriarEnderecoException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoCriarEnderecoException(String message) {
        super(message);
    }

    public FalhaAoCriarEnderecoException() {
        this("Falha ao criar um endereço.");
    }
}

