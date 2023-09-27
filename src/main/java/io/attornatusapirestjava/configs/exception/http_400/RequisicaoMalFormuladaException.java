package io.attornatusapirestjava.configs.exception.http_400;

import java.io.Serial;

public abstract class RequisicaoMalFormuladaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RequisicaoMalFormuladaException(String mensagem) {
        super(String.format("Data em formato inválido: %s", mensagem));
    }
}

