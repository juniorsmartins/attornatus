package io.attornatusapirestjava.configs.exception.http_400;

import java.io.Serial;

public class DataNascimentoInvalidaException extends RequisicaoMalFormuladaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DataNascimentoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
