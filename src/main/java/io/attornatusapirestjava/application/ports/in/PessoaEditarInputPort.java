package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Pessoa;

public interface PessoaEditarInputPort {

    Pessoa editar(Pessoa pessoa);
}

