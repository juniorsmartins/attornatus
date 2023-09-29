package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public final class FalhaAoListarEnderecosException extends ErroInternoDoSistemaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FalhaAoListarEnderecosException(String mensagem) {
        super(mensagem);
    }

    public FalhaAoListarEnderecosException() {
        this("Falha ao listar endereços por pessoa.");
    }
}

