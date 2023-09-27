package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Pessoa;

public interface PessoaEditarOutputPort {

    Pessoa editar(Pessoa pessoa);
}

