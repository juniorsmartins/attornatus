package io.attornatusapirestjava.configs.exception.http_500;

import java.io.Serial;

public abstract class ErroInternoDoSistemaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ErroInternoDoSistemaException(String mensagem) {
        super(mensagem);
    }
}

