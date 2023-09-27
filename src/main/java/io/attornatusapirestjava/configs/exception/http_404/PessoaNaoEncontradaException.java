package io.attornatusapirestjava.configs.exception.http_404;

import java.io.Serial;

public final class PessoaNaoEncontradaException extends RecursoNaoEncontradoException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PessoaNaoEncontradaException(final Long id) {
        this(String.format("Não encontrada pessoa com id: %s", id));
    }
}

